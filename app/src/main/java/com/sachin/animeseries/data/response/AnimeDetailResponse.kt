package com.sachin.animeseries.data.response

import com.google.gson.annotations.SerializedName

data class TopAnimeResponse(
    @SerializedName("data")
    val data: List<AnimeData>
)

data class AnimeDetailResponse(
    @SerializedName("data")
    val data: AnimeData
)

data class AnimeData(
    @SerializedName("mal_id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("synopsis")
    val synopsis: String,
    @SerializedName("episodes")
    val episodes: Int,
    @SerializedName("score")
    val rating: Double,
    @SerializedName("images")
    val images: AnimeImages,
    @SerializedName("trailer")
    val trailer: Trailer?,
)


data class AnimeImages(
    @SerializedName("jpg")
    val jpg: ImageUrls
)

data class ImageUrls(
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("small_image_url")
    val smallImageUrl: String,
    @SerializedName("large_image_url")
    val largeImageUrl: String
)

data class Trailer(
    @SerializedName("youtube_id")
    val youtubeId: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("embed_url")
    val embedUrl: String?
)
