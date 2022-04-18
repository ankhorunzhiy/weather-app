package com.petproject.weatherapp.cities.domain

import com.petproject.weatherapp.cities.domain.model.Weather
import com.petproject.weatherapp.common.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class WeatherUseCase constructor(
  dispatcher: CoroutineDispatcher,
  private val citiesRepository: WeatherRepository): UseCase<String, Collection<Weather>>(dispatcher) {

  override suspend fun execute(parameters: String): Collection<Weather> {
    return emptyList()
  }
}