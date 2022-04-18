package com.petproject.weatherapp.cities.domain

import com.petproject.weatherapp.common.dispatchers.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal object WeatherDomainModule {

  @Singleton
  @Provides
  fun provideUseCase(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    repo: WeatherRepository
  ): WeatherUseCase = WeatherUseCase(dispatcher, repo)

}