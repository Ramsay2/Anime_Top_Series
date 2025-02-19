package com.sachin.animeseries.presentation.fragments.animeDetail

import com.sachin.animeseries.databinding.FragmentAnimeDetailBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : Fragment() {

    private lateinit var binding: FragmentAnimeDetailBinding
    private val viewModel: AnimeDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animeId =
            arguments?.getInt("animeId") ?: throw IllegalArgumentException("Anime ID is required")

        viewModel.fetchAnimeDetail(animeId)

        viewModel.animeDetail.observe(viewLifecycleOwner) { animeDetail ->
            binding.animeTitle.text = animeDetail.title
            binding.animeSynopsis.text = animeDetail.synopsis
            binding.animeEpisodes.text = "Episodes: ${animeDetail.episodes}"
            binding.animeRating.text = "Rating: ${animeDetail.rating}"

            if (animeDetail.trailerUrl != null) {
                binding.youtubePlayerView.visibility = View.VISIBLE
                binding.animePoster.visibility = View.GONE
                binding.youtubePlayerView.addYouTubePlayerListener(object :
                    AbstractYouTubePlayerListener() {
                    override fun onReady(youTubePlayer: YouTubePlayer) {
                        youTubePlayer.loadVideo(animeDetail.trailerUrl, 0f)
                    }
                })
            } else {
                binding.youtubePlayerView.visibility = View.GONE
                binding.animePoster.visibility = View.VISIBLE
                Glide.with(binding.animePoster).load(animeDetail.imageUrl).into(binding.animePoster)
            }
        }
        viewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.youtubePlayerView.release()
    }
}