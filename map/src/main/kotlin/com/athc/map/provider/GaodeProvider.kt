package com.athc.map.provider

import com.athc.common.exception.BaseException
import com.athc.common.util.logger
import com.athc.common.util.toT
import com.athc.map.model.GaodeBaseResponse
import com.fasterxml.jackson.module.kotlin.readValue
import okhttp3.OkHttpClient
import okhttp3.Response
import org.springframework.stereotype.Service

@Service
class GaodeProvider(
    httpClient: OkHttpClient
) : OkHttpClientProvider(httpClient) {

  /**
   * 执行请求
   */
  override fun <T> parseResponse(response: Response, clazz: Class<T>): T {
    val byteArray = response.body!!.bytes()
    val res = mapper.readValue<Map<String, Any?>>(byteArray)
    if ("1" != res.getOrDefault(GaodeBaseResponse::status.name, "0")) {
      val message = res.getOrDefault(GaodeBaseResponse::info.name, "")
      val code = res.getOrDefault(GaodeBaseResponse::infocode.name, "")
      logger.warn("""
        接口请求失败
        API: ${response.request.url}
        错误码：$code
        错误信息：$message
      """.trimIndent())
      throw BaseException(errorCode = code.toString(), message = message.toString())
    }
    return res.toT(clazz)
  }
}