package com.petproject.weatherapp.cities.domain

import com.google.samples.apps.iosched.shared.domain.FlowUseCase
import com.google.samples.apps.iosched.shared.domain.Result
import com.google.samples.apps.iosched.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CitiesUseCase constructor(
  dispatcher: CoroutineDispatcher,
  private val citiesRepository: CitiesRepository): FlowUseCase<Unit, Collection<String>>(dispatcher) {

  override fun execute(parameters: Unit): Flow<Result<Collection<String>>> = flow {
    delay(2000)
    emit(Result.Success(citiesRepository.getCities()))
  }
}