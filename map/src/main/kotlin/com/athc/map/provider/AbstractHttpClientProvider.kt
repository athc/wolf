package com.athc.map.provider

import com.athc.map.service.HttpClientProvider
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import okhttp3.Response

abstract class AbstractHttpClientProvider<K>(
     client: K
) : HttpClientProvider {

  abstract fun <T> parseResponse(response: Response, clazz: Class<T>): T

  companion object {
    val mapper: ObjectMapper = ObjectMapper()
        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
  }
}