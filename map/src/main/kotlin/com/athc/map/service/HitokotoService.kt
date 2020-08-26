package com.athc.map.service

import com.athc.map.model.Hitokoto
import com.athc.map.model.HitokotoParam


/**
 * @author jjj
 * @date 2020/8/24
 * @since JDK1.8
 */
interface HitokotoService {

  /**
   * 获取内容
   * @param param
   */
  fun content(param: HitokotoParam): Hitokoto
}