package com.sachin.animeseries.presentation.fragments.animeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sachin.animeseries.domain.entity.Anime
import com.sachin.animeseries.domain.useCase.GetTopAnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val getTopAnimeUseCase: GetTopAnimeUseCase
) : ViewModel() {

    private val _animeList = MutableLiveData<List<Anime>>()
    val animeList: LiveData<List<Anime>> get() = _animeList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error

    fun fetchTopAnime() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val animeList = getTopAnimeUseCase()
                _animeList.value = animeList
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}