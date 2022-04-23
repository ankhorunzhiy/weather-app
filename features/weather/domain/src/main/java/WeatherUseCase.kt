package com.petproject.weatherapp.cities.domain

import com.petproject.weatherapp.cities.domain.model.Weather
import com.petproject.weatherapp.cities.domain.model.WeatherParams
import com.petproject.weatherapp.common.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay

class WeatherUseCase constructor(
  dispatcher: CoroutineDispatcher,
  private val weatherRepository: WeatherRepository): UseCase<WeatherParams, Weather>(dispatcher) {

  override suspend fun execute(parameters: WeatherParams): Weather {
    return weatherRepository.getWeather(parameters.lat, parameters.lon)
  }
}