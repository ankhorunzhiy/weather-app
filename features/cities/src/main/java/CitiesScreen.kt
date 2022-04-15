package com.petproject.weatherapp.cities

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CitiesScreen(viewModel: CitiesViewModel = viewModel()) {
  Text(text = "Hello!")
}