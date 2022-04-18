package com.petproject.weatherapp.cities

import androidx.core.os.bundleOf
import com.petproject.weatherapp.cities.domain.model.City

val City.asBundle get() = bundleOf("name" to name, "lat" to lat, "lon" to lon, "country" to country)