package com.sachin.animeseries.presentation.fragments.animeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sachin.animeseries.R
import com.sachin.animeseries.databinding.FragmentAnimeListBinding
import com.sachin.animeseries.presentation.adapter.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AnimeListFragment : Fragment() {

    private lateinit var binding: FragmentAnimeListBinding
    private val viewModel: AnimeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModel()
        viewModel.fetchTopAnime()
    }

    private fun setupRecyclerView() {
        binding.animeRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.animeRecyclerView.adapter = AnimeAdapter { anime ->
            findNavController().navigate(
                R.id.action_animeListFragment_to_animeDetailFragment,
                Bundle().apply {
                    putInt("animeId", anime.id)
                }
            )
        }
    }

    private fun observeViewModel() {
        viewModel.animeList.observe(viewLifecycleOwner) { animeList ->
            (binding.animeRecyclerView.adapter as AnimeAdapter).submitList(animeList)
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.animeRecyclerView.visibility = if (isLoading) View.GONE else View.VISIBLE
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        viewModel.error.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
        }
    }
}