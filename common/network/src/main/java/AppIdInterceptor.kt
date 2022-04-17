package com.petproject.weatherapp.common.network

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Response

internal object AppIdInterceptor : Interceptor {

  override fun intercept(chain: Chain): Response {
    val request = chain.request()
    val url: HttpUrl = request.url.newBuilder().addQueryParameter("appid", "f8b1f07f7cded1efc13a25622188889b").build()
    return chain.proceed(request.newBuilder().url(url).build())
  }
}