package com.athc.map.service

import com.athc.map.model.Request

/**
 * @author jjj
 * @date 2020/8/20
 * @since JDK1.8
 */
interface HttpClientProvider {

  /**
   * 执行请求
   */
  fun <T> execute(r: Request, clazz: Class<T>): T
}