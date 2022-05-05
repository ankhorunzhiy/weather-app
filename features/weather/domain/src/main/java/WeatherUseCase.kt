package com.petproject.weatherapp.cities.domain

import com.petproject.weatherapp.cities.domain.model.Weather
import com.petproject.weatherapp.cities.domain.model.WeatherParams
import com.petproject.weatherapp.common.usecase.FlowUseCase
import com.petproject.weatherapp.common.usecase.Result
import com.petproject.weatherapp.common.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WeatherUseCase constructor(
  dispatcher: CoroutineDispatcher,
  private val weatherRepository: WeatherRepository): FlowUseCase<WeatherParams, Weather>(dispatcher) {

  // wrapped flow need move to local repo when local cache will be added
  override fun execute(parameters: WeatherParams): Flow<Result<Weather>> = flow {
    emit(Result.Success(weatherRepository.getWeather(parameters.lat, parameters.lon)))
  }
}