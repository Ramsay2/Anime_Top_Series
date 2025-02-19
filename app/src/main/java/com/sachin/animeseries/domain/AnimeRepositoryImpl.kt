package com.sachin.animeseries.domain

import com.sachin.animeseries.data.ApiService
import com.sachin.animeseries.domain.entity.Anime
import com.sachin.animeseries.domain.entity.AnimeDetail


class AnimeRepositoryImpl(private val apiService: ApiService) : AnimeRepository {

    override suspend fun getTopAnime(): List<Anime> {
        return apiService.getTopAnime().body()?.data?.map { it.toAnime() } ?: emptyList()
    }

    override suspend fun getAnimeDetail(id: Int): AnimeDetail {
        return apiService.getAnimeDetail(id).body()?.data?.toAnimeDetail()
            ?: throw Exception("Anime not found")
    }
}