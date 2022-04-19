package com.petproject.weatherapp.cities.data.datasource

import com.petproject.weatherapp.cities.data.WeatherApi
import com.petproject.weatherapp.cities.data.model.ApiWeather
import com.petproject.weatherapp.cities.domain.model.Weather
import com.petproject.weatherapp.cities.domain.model.Weather.Wind

internal class RemoteWeatherDataSource(private val api: WeatherApi) : WeatherDataSource {

  private val mapper: (ApiWeather) -> Weather = { api ->
    Weather(
      temp = api.main.temp,
      feelsLike = api.main.feels_like,
      tempMin = api.main.temp_min,
      tempMax = api.main.temp_max,
      pressure = api.main.pressure,
      visibility = api.visibility,
      wind = Wind(api.wind.speed),
      name = api.name
    )
  }

  override suspend fun getWeather(lat: Double, lon: Double): Weather = api.getWeather(lat, lon).let(mapper)
}