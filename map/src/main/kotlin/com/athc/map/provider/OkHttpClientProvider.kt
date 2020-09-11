package com.athc.map.provider

import com.athc.common.exception.BaseException
import com.athc.common.util.logger
import com.athc.map.model.Request
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.stereotype.Service
import java.nio.charset.Charset

/**
 * @author jjj
 * @date 2020/9/11
 * @since JDK1.8
 */
@Service
open class OkHttpClientProvider(
    private val client: OkHttpClient
) : AbstractHttpClientProvider<OkHttpClient>(client) {

  override fun <T> parseResponse(response: Response, clazz: Class<T>): T {
    val byteArray = response.body!!.bytes()
    return try {
      mapper.readValue(byteArray, clazz)
    } catch (e: Exception) {
      throw BaseException(errorCode = response.code.toString(), message = response.message)
    }
  }

  /**
   * 执行请求
   */
  override fun <T> execute(r: Request, clazz: Class<T>): T {
    val request = okhttp3.Request.Builder().url(r.url).apply {
      if ("get" == r.method.toLowerCase()) {
        this.get()
      } else {
        val json = jacksonObjectMapper().writeValueAsString(r.params)
        val body = json.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
        this.post(body)
      }
    }.build()
    val response: Response = client.newCall(request).execute()
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

}