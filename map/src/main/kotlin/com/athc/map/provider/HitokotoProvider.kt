package com.athc.map.provider

import com.athc.map.model.Hitokoto
import okhttp3.OkHttpClient
import okhttp3.Response
import java.nio.charset.Charset

class HitokotoProvider(
    httpClient: OkHttpClient
) : AbstractHttpClientProvider(httpClient) {

  /**
   * 执行请求
   */
  override fun <T> parseResponse(response: Response, clazz: Class<T>): T {
    val byteArray = response.body!!.bytes()
    val res = try {
      mapper.readValue(byteArray, clazz)
    } catch (e: Exception) {
      Hitokoto(hitokoto = String(byteArray, Charset.defaultCharset()))
    }
    return res as T
  }
}