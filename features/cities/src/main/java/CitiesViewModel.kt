package com.petproject.weatherapp.cities

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petproject.weatherapp.cities.domain.CitiesUseCase
import com.petproject.weatherapp.cities.domain.model.City
import com.petproject.weatherapp.common.flowbinding.WhileViewSubscribed
import com.petproject.weatherapp.common.usecase.Result
import com.petproject.weatherapp.common.usecase.Result.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CitiesViewModel @Inject constructor(
  handle: SavedStateHandle,
  private val citiesUseCase: CitiesUseCase
) : ViewModel() {

  init {
    Log.d("", "$handle")
  }

  private val citiesChangesInternal by lazy { MutableStateFlow("") }
  // Used to re-run flows on command
  private val refreshSignal = MutableSharedFlow<Unit>()
  // Used to run flows on init and also on command
  private val loadDataSignal: Flow<Unit> = flow {
    emit(Unit)
    emitAll(refreshSignal)
  }

  val uiState: StateFlow<CitiesUiModel> = merge(
    loadDataSignal,
    citiesChangesInternal.debounce(500)
  ).mapLatest { CitiesUiModel(isLoading = false, cities = citiesUseCase(citiesChangesInternal.value)) }
  .stateIn(viewModelScope, WhileViewSubscribed, CitiesUiModel(isLoading = true))

  val citiesChanges = citiesChangesInternal.asStateFlow()

  // implement when pull to refresh will added
  fun refresh() {
    viewModelScope.launch { refreshSignal.emit(Unit) }
  }

  fun setCityName(name: String) = name.let(citiesChangesInternal::value::set)

}


data class CitiesUiModel(
  val isLoading: Boolean = false,
  val cities: Result<Collection<City>> = Success(emptyList())
)