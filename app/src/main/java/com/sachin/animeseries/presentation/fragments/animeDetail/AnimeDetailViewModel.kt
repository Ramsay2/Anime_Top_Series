package com.sachin.animeseries.presentation.fragments.animeDetail

import com.sachin.animeseries.domain.entity.AnimeDetail
import com.sachin.animeseries.domain.useCase.GetAnimeDetailsUseCase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeDetailViewModel @Inject constructor(
    private val getAnimeDetailUseCase: GetAnimeDetailsUseCase
) : ViewModel() {

    private val _animeDetail = MutableLiveData<AnimeDetail>()
    val animeDetail: LiveData<AnimeDetail> get() = _animeDetail

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> get() = _error


    fun fetchAnimeDetail(animeId: Int) {
        viewModelScope.launch {
            try {
                val animeDetail = getAnimeDetailUseCase(animeId)
                _animeDetail.value = animeDetail
            } catch (e: Exception) {
                _error.value = e.message
            }
        }
    }
}