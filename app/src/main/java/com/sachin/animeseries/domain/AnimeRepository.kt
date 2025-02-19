package com.sachin.animeseries.domain

import com.sachin.animeseries.domain.entity.Anime
import com.sachin.animeseries.domain.entity.AnimeDetail

interface AnimeRepository {
    suspend fun getTopAnime(): List<Anime>
    suspend fun getAnimeDetail(id: Int): AnimeDetail
}