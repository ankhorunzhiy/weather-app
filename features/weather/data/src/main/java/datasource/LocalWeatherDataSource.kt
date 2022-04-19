package com.petproject.weatherapp.cities.data.datasource

import com.petproject.weatherapp.cities.domain.model.Weather
import java.lang.IllegalStateException

internal class LocalWeatherDataSource : WeatherDataSource {

  override suspend fun getWeather(lat: Double, lon: Double): Weather {
    throw IllegalStateException("Will be implement later")
  }
}