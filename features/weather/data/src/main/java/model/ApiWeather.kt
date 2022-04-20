package com.petproject.weatherapp.weather.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ApiWeather(
  @SerialName("main")
  val main: ApiMain,
  @SerialName("visibility")
  val visibility: Int,
  @SerialName("wind")
  val wind: ApiWind,
  @SerialName("name")
  val name: String
) {
  @Serializable
  class ApiMain(
    @SerialName("temp")
    val temp: Double ,
    @SerialName("feels_like")
    val feels_like: Double,
    @SerialName("temp_min")
    val temp_min: Double,
    @SerialName("temp_max")
    val temp_max: Double,
    @SerialName("pressure")
    val pressure: Int
  )

  @Serializable
  class ApiWind(
    @SerialName("speed")
    val speed: Double
  )
}