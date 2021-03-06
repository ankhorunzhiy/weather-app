package com.petproject.weatherapp.weather.data.datasource

import com.petproject.weatherapp.cities.domain.model.Weather
import com.petproject.weatherapp.weather.data.WeatherApi
import com.petproject.weatherapp.weather.data.model.ApiWeather

internal class RemoteWeatherDataSource(private val api: WeatherApi) : WeatherDataSource {

  private val mapper: (ApiWeather) -> Weather = { api ->
    Weather(
      temperature = api.main.temp,
      feelsLike = api.main.feels_like,
      tempMin = api.main.temp_min,
      tempMax = api.main.temp_max,
      pressure = api.main.pressure,
      visibility = api.visibility,
      windSpeed = api.wind.speed,
      name = api.name,
      lat = api.coord.lat,
      lon = api.coord.lon
    )
  }

  override suspend fun getWeather(lat: Double, lon: Double): Weather = api.getWeather(lat, lon).let(mapper)
}