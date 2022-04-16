package com.petproject.weatherapp.cities

import android.util.Log
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.samples.apps.iosched.shared.domain.succeeded
import com.petproject.weatherapp.common.flowui.rememberWithLifecycle

@Composable
fun CitiesScreen(viewModel: CitiesViewModel = viewModel()) {
  val uiState by rememberWithLifecycle(viewModel.uiState).collectAsState(CitiesUiModel(isLoading = true))
  when {
    uiState.isLoading -> StateLoading()
    uiState.cities.succeeded -> StateCitiesContent()
    else -> StateError(viewModel)
  }
}

@Composable
private fun StateLoading() {
  CircularProgressIndicator(Modifier.wrapContentHeight().wrapContentWidth())
}

@Composable
private fun StateCitiesContent() {}

@Composable
private fun StateError(viewModel: CitiesViewModel) {
  Button(onClick = { viewModel.refresh() }, modifier = Modifier
    .wrapContentWidth()
    .wrapContentHeight()) {
    Text(text = "Error! Try again")
  }
}