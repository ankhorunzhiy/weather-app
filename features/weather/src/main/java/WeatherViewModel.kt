package com.petproject.weatherapp.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petproject.weatherapp.cities.domain.WeatherUseCase
import com.petproject.weatherapp.cities.domain.model.WeatherParams
import com.petproject.weatherapp.weather.WeatherUIModule
import com.petproject.weatherapp.common.flowbinding.WhileViewSubscribed
import com.petproject.weatherapp.weather.WeatherUIModel.Content
import com.petproject.weatherapp.weather.WeatherUIModel.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
  private val args: WeatherArgs,
  private val weatherUseCase: WeatherUseCase) : ViewModel() {

  private val refreshSignal = MutableSharedFlow<Unit>()
  // Used to run flows on init and also on command
  private val loadDataSignal: Flow<Unit> = flow {
    emit(Unit)
    emitAll(refreshSignal)
  }

  private val pull = MutableSharedFlow<Boolean>()

  private val pullSignal: Flow<Boolean> = flow {
    emitAll(pull)
  }

  val uiState: StateFlow<WeatherUIModel> = loadDataSignal.mapLatest {
    Content(city = args.name, country = args.country, weatherUseCase(WeatherParams(args.lat, args.lon)))
  }.onEach { pull.emit(false) }.stateIn(viewModelScope, WhileViewSubscribed, Loading)

  val isRefreshing: StateFlow<Boolean> = pullSignal.stateIn(viewModelScope, WhileViewSubscribed, false)

  fun refresh() {
    viewModelScope.launch { refreshSignal.emit(Unit) }
    viewModelScope.launch { pull.emit(true) }
  }
}