package com.petproject.weatherapp.cities

import android.util.Log
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.petproject.weatherapp.common.flowui.rememberFlowWithLifecycle

@Composable
fun CitiesScreen(viewModel: CitiesViewModel = viewModel()) {
  val uiState by rememberFlowWithLifecycle(viewModel.uiState).collectAsState(
    CitiesUiModel(isLoading = true)
  )
}