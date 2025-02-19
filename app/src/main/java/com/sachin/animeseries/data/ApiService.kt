package com.sachin.animeseries.data

import com.sachin.animeseries.data.response.AnimeDetailResponse
import com.sachin.animeseries.data.response.TopAnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("top/anime")
    suspend fun getTopAnime(): Response<TopAnimeResponse>

    @GET("anime/{id}")
    suspend fun getAnimeDetail(@Path("id") id: Int): Response<AnimeDetailResponse>
}