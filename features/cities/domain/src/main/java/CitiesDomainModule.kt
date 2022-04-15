package com.petproject.weatherapp.cities.domain

import com.petproject.weatherapp.cities.domain.CitiesRepository
import com.petproject.weatherapp.cities.domain.CitiesUseCase
import com.petproject.weatherapp.common.dispatchers.IoDispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
internal class CitiesDomainModule {

  @Singleton
  @Provides
  fun provideRepository(): CitiesRepository = FakeCitiesRepository()

  @Singleton
  @Provides
  fun provideUseCase(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    repo: CitiesRepository
  ): CitiesUseCase = CitiesUseCase(dispatcher, repo)

}