package com.sachin.animeseries.domain.useCase

import com.sachin.animeseries.domain.AnimeRepository
import com.sachin.animeseries.domain.entity.Anime
import javax.inject.Inject

class GetTopAnimeUseCase @Inject constructor(private val repository: AnimeRepository) {
    suspend operator fun invoke(): List<Anime> {
        return repository.getTopAnime()
    }
}