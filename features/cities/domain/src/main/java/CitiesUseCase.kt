package com.petproject.weatherapp.cities.domain

import com.petproject.weatherapp.cities.domain.model.City
import com.petproject.weatherapp.common.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher

class CitiesUseCase constructor(
  dispatcher: CoroutineDispatcher,
  private val citiesRepository: CitiesRepository): UseCase<String, Collection<City>>(dispatcher) {

  override suspend fun execute(parameters: String): Collection<City> {
    if (parameters.length < 3) return emptyList()
    return citiesRepository.getCities(parameters)
  }
}