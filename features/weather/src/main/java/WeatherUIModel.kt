package com.petproject.weatherapp.weather

import com.petproject.weatherapp.cities.domain.model.Weather
import com.petproject.weatherapp.common.usecase.Result
import com.petproject.weatherapp.common.usecase.Result.Success

sealed interface WeatherUIModel {
  object Loading : WeatherUIModel
  data class Content(val city: String, val country: String, val weather: Weather) : WeatherUIModel
  data class Error(val exception: Exception) : WeatherUIModel

  companion object {
    fun from(city: String, country: String, result: Result<Weather>): WeatherUIModel {
      return when(result) {
        is Success -> Content(city = city, country = country, result.data)
        is Result.Error -> Error(result.exception)
        else -> error("Loading not implemented yet")
      }
    }
  }
}