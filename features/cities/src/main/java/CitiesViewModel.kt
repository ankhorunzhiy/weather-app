package com.petproject.weatherapp.cities

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.samples.apps.iosched.shared.domain.Result
import com.petproject.weatherapp.cities.domain.CitiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.zip
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
  private val citiesUseCase: CitiesUseCase
) : ViewModel() {

  private val refreshSignal = MutableSharedFlow<Unit>()
  private val loadDataSignal: Flow<Unit> = flow {
    emit(Unit)
    emitAll(refreshSignal)
  }

  val uiState: StateFlow<CitiesUiModel> = loadDataSignal.combine(citiesUseCase(Unit)) { _, cities ->
    CitiesUiModel(isLoading = false, cities = cities) }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), CitiesUiModel(isLoading = true))
}


data class CitiesUiModel(
  val isLoading: Boolean = false,
  val cities: Result<Collection<String>> = Result.Success(emptyList())
)