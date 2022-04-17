package com.petproject.weatherapp.cities.domain

import kotlinx.coroutines.flow.Flow

interface CitiesRepository {
    suspend fun getCities(): Collection<String>
}

internal class FakeCitiesRepository : CitiesRepository {

  override suspend fun getCities(): Collection<String> {
    return listOf("Kiev", "Kharkov", "Mariupol", "Melitopol", "Lviv", "Odessa", "Donetsk", "Izum", "Kharkiv", "Kherson", "Volnovakha", "Sumy")
  }
}