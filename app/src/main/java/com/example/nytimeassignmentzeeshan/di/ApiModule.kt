package com.example.nytimeassignmentzeeshan.di

import com.example.nytimeassignmentzeeshan.api.ApiServices
import com.example.nytimeassignmentzeeshan.api.ApiClient
import com.example.nytimeassignmentzeeshan.utils.Constants
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.example.nytimeassignmentzeeshan.repository.ArticleListRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Provides
    fun provideNyTimeRepositoryInterface(): ArticleListRepository {
        return ArticleListRepository(provideRetrofitService());
    }
    @Singleton
    @Provides
    fun provideRetrofitService(): ApiServices =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(ApiClient.getApiClient())
            .build()
            .create(ApiServices::class.java)

}