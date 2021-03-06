package com.petproject.weatherapp.cities.domain

import com.petproject.weatherapp.cities.domain.model.Weather
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {
  suspend fun getWeather(lat: Double, lon: Double): Weather
}