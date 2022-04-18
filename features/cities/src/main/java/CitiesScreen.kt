package com.petproject.weatherapp.cities

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.petproject.weatherapp.cities.domain.model.City
import com.petproject.weatherapp.common.flowui.rememberWithLifecycle
import com.petproject.weatherapp.common.usecase.dataOr
import com.petproject.weatherapp.common.usecase.succeeded

@Composable
fun CitiesScreen(viewModel: CitiesViewModel = viewModel()) {
  val uiState by rememberWithLifecycle(viewModel.uiState).collectAsState(CitiesUiModel(isLoading = true))
  when {
    uiState.isLoading -> StateLoading()
    uiState.cities.succeeded -> StateCitiesContent(uiState.cities.dataOr(emptyList()), viewModel)
    else -> StateError(viewModel)
  }
}

@Composable
private fun StateLoading() {
  CircularProgressIndicator(Modifier.wrapContentHeight().wrapContentWidth())
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun StateCitiesContent(items: Collection<City>, viewModel: CitiesViewModel) {
  Column {
    StateHeader(viewModel)
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
      items(items.toList()) { city -> Text(text = listOf(city.name, city.country).joinToString(), fontSize = 20.sp, color = Color.DarkGray, modifier = Modifier.padding(20.dp, 10.dp))}
    }
  }
}

@Composable
private fun StateError(viewModel: CitiesViewModel) {
  Column {
    StateHeader(viewModel)
    Text(text = "Oooops, something went wrong",
      fontSize = 28.sp,
      textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth()
    )
  }
}

@Composable
private fun StateHeader(viewModel: CitiesViewModel) {
  val citiesTextChanges = viewModel.citiesChanges.collectAsState()
  OutlinedTextField(
    value = citiesTextChanges.value,
    onValueChange = viewModel::setCityName,
    label = { Text("Choose city") },
    modifier = Modifier.fillMaxWidth().padding(16.dp)
  )
}