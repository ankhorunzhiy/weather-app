package com.petproject.weatherapp.cities.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ApiCity(
  @SerialName("name")
  val name: String,
  @SerialName("country")
  val country: String,
  @SerialName("lat")
  val lat: Double,
  @SerialName("lon")
  val lon: Double,
)