package com.sachin.animeseries.domain.entity

data class AnimeDetail(
    val id: Int,
    val title: String,
    val synopsis: String,
    val episodes: Int,
    val rating: Double,
    val imageUrl: String,
    val trailerUrl: String?,
)
