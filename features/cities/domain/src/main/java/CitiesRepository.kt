package com.petproject.weatherapp.cities.domain

import com.petproject.weatherapp.cities.domain.model.City
import kotlinx.coroutines.flow.Flow

interface CitiesRepository {
    suspend fun getCities(query: String): Collection<City>
}