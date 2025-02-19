package com.sachin.animeseries.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sachin.animeseries.databinding.ItemAnimeBinding
import com.sachin.animeseries.domain.entity.Anime

class AnimeAdapter(
    private val onItemClick: (Anime) -> Unit
) : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private val animeList = mutableListOf<Anime>()

    fun submitList(list: List<Anime>) {
        animeList.clear()
        animeList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val binding = ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(animeList[position])
    }

    override fun getItemCount(): Int = animeList.size

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(anime: Anime) {
            binding.animeTitle.text = anime.title
            binding.animeEpisodes.text = "Episodes: ${anime.episodes}"
            binding.animeRating.text = "Rating: ${anime.rating}"
            // Load image using Glide
            Glide.with(binding.animePoster).load(anime.imageUrl).into(binding.animePoster)
            binding.root.setOnClickListener { onItemClick(anime) }
        }
    }
}