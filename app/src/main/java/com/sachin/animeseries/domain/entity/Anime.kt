package com.sachin.animeseries.domain.entity

data class Anime(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val rating: Double,
    val episodes: Int,
)
