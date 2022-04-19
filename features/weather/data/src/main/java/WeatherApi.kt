package com.petproject.weatherapp.cities.data

import com.petproject.weatherapp.cities.data.model.ApiWeather
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {

  @GET("/data/2.5/weather")
  suspend fun getWeather(@Query("lat") lat: Double, @Query("lon") lon: Double): ApiWeather
}