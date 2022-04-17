package com.petproject.weatherapp.cities

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.TextUnitType.Companion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.samples.apps.iosched.shared.domain.succeeded
import com.google.samples.apps.iosched.shared.domain.dataOr
import com.petproject.weatherapp.common.flowui.rememberWithLifecycle

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
  CircularProgressIndicator(
    Modifier
      .wrapContentHeight()
      .wrapContentWidth())
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun StateCitiesContent(items: Collection<String>, viewModel: CitiesViewModel) {
  Column {
    Text(text = "Choose city", fontSize = 32.sp, color = Color.Black, textAlign = TextAlign.Center, modifier = Modifier
      .fillMaxWidth()
      .padding(top = 16.dp))
    LazyColumn(modifier = Modifier.padding(top = 20.dp).fillMaxWidth()) {
      items(items.toList()) { city -> Text(text = city, fontSize = 28.sp, color = Color.DarkGray, modifier = Modifier.padding(20.dp, 16.dp))}
    }
  }
}

@Composable
private fun StateError(viewModel: CitiesViewModel) {
  Button(onClick = { viewModel.refresh() }, modifier = Modifier
    .wrapContentWidth()
    .wrapContentHeight()) {
    Text(text = "Error! Try again")
  }
}