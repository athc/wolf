package com.athc.map.service

import com.athc.common.util.queryString
import com.athc.map.config.GaodeMapProperties
import com.athc.map.constant.HitokotoUrl
import com.athc.map.model.Hitokoto
import com.athc.map.model.HitokotoParam
import com.athc.map.model.Request
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class HitokotoServiceImpl(
    private val hitokotoProvider: AbstractHttpClientProvider,
    private val properties: GaodeMapProperties
) : HitokotoService {
  /**
   * 获取内容
   * @param param
   */
  @Cacheable(cacheNames = ["twoSeconds"], key = "'content'")
  override fun content(param: HitokotoParam): Hitokoto {
    val paramString = param.queryString()
    properties.key
    val url = HitokotoUrl.URL + if (paramString.isNotBlank()) "?$paramString" else ""
    val r = Request(url = url)

    return hitokotoProvider.execute(r, Hitokoto::class.java)
  }
}