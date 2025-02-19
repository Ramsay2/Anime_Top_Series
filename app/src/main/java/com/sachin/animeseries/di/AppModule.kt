package com.sachin.animeseries.di

import com.sachin.animeseries.data.ApiService
import com.sachin.animeseries.domain.AnimeRepository
import com.sachin.animeseries.domain.AnimeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideJikanApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/v4/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideAnimeRepository(apiService: ApiService): AnimeRepository {
        return AnimeRepositoryImpl(apiService)
    }
}