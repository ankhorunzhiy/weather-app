package com.petproject.weatherapp.cities.domain

import com.google.samples.apps.iosched.shared.domain.FlowUseCase
import com.google.samples.apps.iosched.shared.domain.Result
import com.google.samples.apps.iosched.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.IllegalStateException

class CitiesUseCase constructor(
  dispatcher: CoroutineDispatcher,
  private val citiesRepository: CitiesRepository): UseCase<Unit, Collection<String>>(dispatcher) {

  override suspend fun execute(parameters: Unit): Collection<String> {
    // Emit network
    delay(2000)
    return citiesRepository.getCities()
  }
}