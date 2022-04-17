package com.petproject.weatherapp.common.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class NetworkModule {

  @OptIn(ExperimentalSerializationApi::class)
  @Singleton
  @Provides
  fun provideRetrofit(client: OkHttpClient, json: Json): Retrofit = Retrofit.Builder()
    .baseUrl("http://api.openweathermap.org")
    .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
    .client(client)
    .build()

  @Singleton
  @Provides
  fun provideClient(): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(AppIdInterceptor)
    .addInterceptor(HttpLoggingInterceptor().apply { level = BODY })
    .build()

  @Singleton
  @Provides
  fun provideJson(): Json = Json {
    ignoreUnknownKeys = true
    isLenient = true
  }
}