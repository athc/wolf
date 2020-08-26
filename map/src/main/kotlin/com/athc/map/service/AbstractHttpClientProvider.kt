package com.athc.map.service

import com.athc.common.exception.BaseException
import com.athc.common.util.logger
import com.athc.map.model.Request
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import okhttp3.OkHttpClient
import okhttp3.Response
import java.nio.charset.Charset

abstract class AbstractHttpClientProvider(
    private val httpClient: OkHttpClient
) : HttpClientService {

  /**
   * 执行请求
   */
  override fun <T> execute(r: Request, clazz: Class<T>): T {
    val request = okhttp3.Request.Builder().url(r.url).apply {
      if ("get" == r.method.toLowerCase()) {
        this.get()
      } else {
        // TODO: post
      }
    }.build()
    val response: Response = httpClient.newCall(request).execute()
    if (logger.isInfoEnabled) {
      logger.debug(mapper.writeValueAsString(response))
    }

    if (!response.isSuccessful || null == response.body) {
      logger.info(
          """
            调用接口异常
            请求地址：${response.request.url}
            响应内容：${response.message}
            响应body：${String(response.body?.bytes() ?: byteArrayOf(), Charset.defaultCharset())}
          """.trimIndent()
      )
      throw BaseException(errorCode = response.code.toString(), message = response.message)
    }

    return this.parseResponse(response, clazz)
  }

  abstract fun <T> parseResponse(response: Response, clazz: Class<T>): T

  companion object {
    val mapper: ObjectMapper = ObjectMapper()
        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
  }
}