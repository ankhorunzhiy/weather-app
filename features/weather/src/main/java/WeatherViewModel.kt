package com.petproject.weatherapp.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.petproject.weatherapp.cities.domain.WeatherUseCase
import com.petproject.weatherapp.cities.domain.model.WeatherParams
import com.petproject.weatherapp.common.flowbinding.WhileViewSubscribed
import com.petproject.weatherapp.weather.WeatherUIModel.Content
import com.petproject.weatherapp.weather.WeatherUIModel.Loading
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.mapLatest
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

  private val pullToRefreshSignal = MutableSharedFlow<Boolean>()

  private val pullDataSignal: Flow<Boolean> = flow {
    emitAll(pullToRefreshSignal)
  }

  val uiState: StateFlow<WeatherUIModel> = loadDataSignal.mapLatest {
    Content(city = args.name, country = args.country, weatherUseCase(WeatherParams(args.lat, args.lon)))
  }.onEach { pullToRefreshSignal.emit(false) }.stateIn(viewModelScope, WhileViewSubscribed, Loading)

  val isRefreshing: StateFlow<Boolean> = pullDataSignal.stateIn(viewModelScope, WhileViewSubscribed, false)

  fun refresh() {
    viewModelScope.launch { pullToRefreshSignal.emit(true) }
    viewModelScope.launch { refreshSignal.emit(Unit) }
  }
}