package com.petproject.weatherapp.cities.data

import com.petproject.weatherapp.cities.data.datasource.LocalWeatherDataSource
import com.petproject.weatherapp.cities.data.datasource.RemoteWeatherDataSource
import com.petproject.weatherapp.cities.data.datasource.WeatherDataSource
import com.petproject.weatherapp.cities.domain.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object WeatherDataModule {

  @Provides
  fun provideApi(retrofit: Retrofit): WeatherApi = retrofit.create()

  @Singleton
  @Provides
  @Named("localDataSource")
  fun provideLocalDataSource(): WeatherDataSource = LocalWeatherDataSource()

  @Singleton
  @Provides
  @Named("remoteDataSource")
  fun provideRemoteDataSource(api: WeatherApi): WeatherDataSource = RemoteWeatherDataSource(api)

  @Singleton
  @Provides
  fun provideRepo(
    @Named("localDataSource") localWeatherDataSource: WeatherDataSource,
    @Named("remoteDataSource") remoteWeatherDataSource: WeatherDataSource
  ): WeatherRepository = DefaultWeatherRepository(localWeatherDataSource, remoteWeatherDataSource)

}