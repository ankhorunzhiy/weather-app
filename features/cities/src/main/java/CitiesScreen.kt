package com.petproject.weatherapp.cities

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Vertical
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.petproject.weatherapp.cities.domain.model.City
import com.petproject.weatherapp.common.flowui.rememberWithLifecycle
import com.petproject.weatherapp.common.navigation.navigate
import com.petproject.weatherapp.common.usecase.dataOr
import com.petproject.weatherapp.common.usecase.succeeded

@Composable
fun CitiesScreen(viewModel: CitiesViewModel = hiltViewModel(), navController: NavController) {
  val uiState by rememberWithLifecycle(viewModel.uiState).collectAsState(CitiesUiModel(isLoading = true))
  when {
    uiState.isLoading -> StateLoading()
    uiState.cities.succeeded -> StateCitiesContent(uiState.cities.dataOr(emptyList()), viewModel, navController)
    else -> StateError(viewModel)
  }
}

@Composable
private fun StateLoading() {
  Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
    CircularProgressIndicator(
      Modifier
        .width(50.dp)
        .height(50.dp))
  }

}

@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
@Composable
private fun StateCitiesContent(items: Collection<City>, viewModel: CitiesViewModel, navController: NavController) {
  val keyboardController = LocalSoftwareKeyboardController.current
  Column {
    StateHeader(viewModel)
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
      items(items.toList()) { city ->
        Box(modifier = Modifier
          .fillMaxWidth()
          .clickable {
            keyboardController?.hide()
            navController.navigate(route = "weather", args = city.asBundle)
          }) {
          Text(text = listOf(city.name, city.country).joinToString(), fontSize = 20.sp, color = Color.DarkGray, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 10.dp))
        }
      }
    }
  }
}

@Composable
private fun StateError(viewModel: CitiesViewModel) {
  Column(modifier = Modifier
    .fillMaxWidth()
    .fillMaxHeight()) {
    StateHeader(viewModel)
    Box(
      contentAlignment = Alignment.BottomCenter,
      modifier = Modifier.fillMaxSize()
    ) {
      Snackbar(
        modifier = Modifier.padding(8.dp)
      ) { Text(text = "Some error occur") }
    }
  }
}

@Composable
private fun StateHeader(viewModel: CitiesViewModel) {
  val citiesTextChanges = viewModel.citiesChanges.collectAsState()
  val focusRequester = remember { FocusRequester() }
  LaunchedEffect(true) { focusRequester.requestFocus() }
  OutlinedTextField(
    value = citiesTextChanges.value,
    onValueChange = viewModel::setCityName,
    label = { Text("Choose city") },
    modifier = Modifier.focusRequester(focusRequester).fillMaxWidth().padding(16.dp)
  )
}