package com.sachin.animeseries.domain

import com.sachin.animeseries.data.response.AnimeData
import com.sachin.animeseries.domain.entity.Anime
import com.sachin.animeseries.domain.entity.AnimeDetail

fun AnimeData.toAnimeDetail(): AnimeDetail {
    return AnimeDetail(
        id = id,
        title = title,
        synopsis = synopsis,
        episodes = episodes,
        rating = rating,
        imageUrl = images.jpg.imageUrl,
        trailerUrl = trailer?.youtubeId
    )
}
fun AnimeData.toAnime(): Anime {
    return Anime(
        id = id,
        title = title,
        episodes = episodes,
        rating = rating,
        imageUrl = images.jpg.imageUrl,
    )
}

