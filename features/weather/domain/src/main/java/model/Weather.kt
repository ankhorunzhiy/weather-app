package com.petproject.weatherapp.cities.domain.model

data class Weather(
  val temp: Double,
  val feelsLike: Double,
  val tempMin: Double,
  val tempMax: Double,
  val pressure: Int,
  val visibility: Int,
  val wind: Wind,
  val name: String
) {
  class Wind(val speed: Double)
}