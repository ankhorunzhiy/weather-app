package com.petproject.weatherapp.cities.data

import com.petproject.weatherapp.cities.data.model.ApiCity
import com.petproject.weatherapp.cities.domain.CitiesRepository
import com.petproject.weatherapp.cities.domain.model.City
import kotlinx.coroutines.delay
import java.lang.IllegalStateException

internal class GeoCitiesRepository(private val api: CitiesApi) :
  CitiesRepository {

  private val cityMapper : (ApiCity) -> City = { api ->
    City(name = api.name, country = api.country, lat = api.lat, lon = api.lon)
  }

  override suspend fun getCities(query: String): Collection<City> {
    return api.getCities(query = query).map(cityMapper)
  }
}