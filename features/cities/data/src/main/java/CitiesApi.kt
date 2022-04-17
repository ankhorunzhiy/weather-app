package com.petproject.weatherapp.cities.data

import com.petproject.weatherapp.cities.data.model.ApiCity
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface CitiesApi {

  @GET("/geo/1.0/direct")
  suspend fun getCities(@Query("q") query: String, @Query("limit") limit: Int = 20): Collection<ApiCity>
}