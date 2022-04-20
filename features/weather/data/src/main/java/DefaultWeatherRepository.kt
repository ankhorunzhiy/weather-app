package com.petproject.weatherapp.weather.data

import com.petproject.weatherapp.cities.domain.WeatherRepository
import com.petproject.weatherapp.cities.domain.model.Weather
import com.petproject.weatherapp.weather.data.datasource.WeatherDataSource
import kotlinx.coroutines.delay
import java.lang.IllegalStateException
import javax.inject.Inject
import javax.inject.Named

internal class DefaultWeatherRepository (
  private val localDataSource: WeatherDataSource,
  private val remoteDataSource: WeatherDataSource,
) : WeatherRepository {

  override suspend fun getWeather(lat: Double, lon: Double): Weather {
    return remoteDataSource.getWeather(lat, lon)
  }
}