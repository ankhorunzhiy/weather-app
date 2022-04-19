package com.petproject.weatherapp.weather

import com.petproject.weatherapp.cities.domain.model.Weather
import com.petproject.weatherapp.common.usecase.Result
import java.lang.Exception

sealed class WeatherUIModel {
  object Loading : WeatherUIModel()
  data class Content(val city: String, val country: String, val result: Result<Weather>) : WeatherUIModel()
}