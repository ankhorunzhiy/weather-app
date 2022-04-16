package com.petproject.weatherapp.cities

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.samples.apps.iosched.shared.domain.Result
import com.petproject.weatherapp.cities.domain.CitiesUseCase
import com.petproject.weatherapp.common.flowbinding.WhileViewSubscribed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
  private val citiesUseCase: CitiesUseCase
) : ViewModel() {

  // Used to re-run flows on command
  private val refreshSignal = MutableSharedFlow<Unit>()
  // Used to run flows on init and also on command
  private val loadDataSignal: Flow<Unit> = flow {
    emit(Unit)
    emitAll(refreshSignal)
  }

  val uiState: StateFlow<CitiesUiModel> = loadDataSignal.mapLatest {
    CitiesUiModel(isLoading = false, cities = citiesUseCase(Unit))
  }.stateIn(viewModelScope, WhileViewSubscribed, CitiesUiModel(isLoading = true))

  fun refresh() {
    viewModelScope.launch { refreshSignal.emit(Unit) }
  }
}


data class CitiesUiModel(
  val isLoading: Boolean = false,
  val cities: Result<Collection<String>> = Result.Success(emptyList())
)