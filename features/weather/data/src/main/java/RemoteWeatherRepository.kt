package com.petproject.weatherapp.cities.data

import com.petproject.weatherapp.cities.domain.WeatherRepository
import com.petproject.weatherapp.cities.domain.model.Weather
import kotlinx.coroutines.delay
import java.lang.IllegalStateException

internal class RemoteWeatherRepository(private val api: WeatherApi) :
  WeatherRepository {

  override suspend fun getWeather(query: String): Collection<Weather> {
    return emptyList()
  }
}