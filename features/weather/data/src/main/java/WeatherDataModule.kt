package com.petproject.weatherapp.cities.data

import com.petproject.weatherapp.cities.domain.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object WeatherDataModule {

  @Provides
  fun provideApi(retrofit: Retrofit): WeatherApi = retrofit.create()

  @Singleton
  @Provides
  fun provideRepository(api: WeatherApi): WeatherRepository =
    RemoteWeatherRepository(api)

}