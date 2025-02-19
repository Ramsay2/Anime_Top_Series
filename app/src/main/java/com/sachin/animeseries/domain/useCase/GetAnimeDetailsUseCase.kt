package com.sachin.animeseries.domain.useCase

import com.sachin.animeseries.domain.AnimeRepository
import javax.inject.Inject

class GetAnimeDetailsUseCase @Inject constructor(private val repository: AnimeRepository) {
    suspend operator fun invoke(animeId: Int) = repository.getAnimeDetail(animeId)
}