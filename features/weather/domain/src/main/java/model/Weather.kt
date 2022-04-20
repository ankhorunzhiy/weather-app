package com.petproject.weatherapp.cities.domain.model

data class Weather(
  val temperature: Double,
  val feelsLike: Double,
  val tempMin: Double,
  val tempMax: Double,
  val pressure: Int,
  val visibility: Int,
  val windSpeed: Double,
  val name: String
)