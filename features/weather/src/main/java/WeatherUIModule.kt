package com.petproject.weatherapp.weather

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@InstallIn(ViewModelComponent::class)
@Module
internal object WeatherUIModule {

  @Provides
  @ViewModelScoped
  fun provideArgs(handle: SavedStateHandle): WeatherArgs {
    return WeatherArgs(
      name = handle.get<String>("name")!!,
      country = handle.get<String>("country")!!,
      lat = handle.get<Double>("lat")!!,
      lon = handle.get<Double>("lon")!!
    )
  }
}