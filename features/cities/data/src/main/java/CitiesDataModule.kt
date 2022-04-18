package com.petproject.weatherapp.cities.data

import com.petproject.weatherapp.cities.domain.CitiesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object CitiesDataModule {

  @Provides
  fun provideApi(retrofit: Retrofit): CitiesApi = retrofit.create()

  @Singleton
  @Provides
  fun provideRepository(api: CitiesApi): CitiesRepository =
    GeoCitiesRepository(api)

}