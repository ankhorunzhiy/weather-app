package com.petproject.weatherapp.weather.data.datasource

import com.petproject.weatherapp.cities.domain.model.Weather

internal interface WeatherDataSource {
  suspend fun getWeather(lat: Double, lon: Double): Weather
}