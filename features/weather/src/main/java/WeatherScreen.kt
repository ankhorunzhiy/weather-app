package com.petproject.weatherapp.weather

import android.util.Log
import androidx.compose.foundation.gestures.Orientation.Vertical
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.petproject.weatherapp.cities.domain.model.Weather
import com.petproject.weatherapp.common.flowui.rememberWithLifecycle
import com.petproject.weatherapp.common.usecase.data
import com.petproject.weatherapp.weather.WeatherUIModel.Content
import com.petproject.weatherapp.weather.WeatherUIModel.Loading

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = hiltViewModel()) {
  val uiState by rememberWithLifecycle(viewModel.uiState).collectAsState(Loading)
  when(val state = uiState) { // smart cast uiState
    is Loading -> StateWeatherLoading()
    is Content -> StateWeatherContent(state, viewModel)
    else -> error("Unknown ui state")
  }
}

@Composable
private fun StateWeatherLoading() {
  Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    CircularProgressIndicator(
      Modifier
        .width(50.dp)
        .height(50.dp))
  }
}

@Composable
private fun StateWeatherContent(state: Content, viewModel: WeatherViewModel) {
  val isRefreshing by viewModel.isRefreshing.collectAsState()
  SwipeRefresh(
    state = rememberSwipeRefreshState(isRefreshing),
    onRefresh = { viewModel.refresh() },
    indicator = { stateRefresh, trigger -> SwipeRefreshIndicator(
      state = stateRefresh,
      refreshTriggerDistance = trigger,
      contentColor = MaterialTheme.colors.primaryVariant)
    }
  ) {
    state.result.data?.let { data -> StateWeatherSuccess(state.city, state.country, data) }?: StateWeatherError()
  }
}


@Composable
private fun StateWeatherSuccess(city: String, country: String, weather: Weather) {
  LazyColumn {
    item { Text(text = "Current weather in ${listOf(city, country).joinToString()}", fontSize = 24.sp, modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp, 8.dp)) }
    item { Text(text = "Temperature: ${weather.temperature}", fontSize = 18.sp, modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp, 8.dp)) }
    item { Text(text = "Feels like: ${weather.feelsLike}", fontSize = 18.sp, modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp, 8.dp)) }
    item { Text(text = "Minimum temperature: ${weather.tempMin}", fontSize = 18.sp, modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp, 8.dp)) }
    item { Text(text = "Maximum temperature: ${weather.tempMax}", fontSize = 18.sp, modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp, 8.dp)) }
    item { Text(text = "Pressure: ${weather.pressure}", fontSize = 18.sp, modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp, 8.dp)) }
    item { Text(text = "Visibility: ${weather.visibility}", fontSize = 18.sp, modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp, 8.dp)) }
    item { Text(text = "Wind: ${weather.windSpeed}", fontSize = 18.sp, modifier = Modifier
      .fillMaxWidth()
      .padding(16.dp, 8.dp)) }
  }
}

@Composable
private fun StateWeatherError() {
  Column(Modifier.verticalScroll(rememberScrollState())) {
    // content
  }
}