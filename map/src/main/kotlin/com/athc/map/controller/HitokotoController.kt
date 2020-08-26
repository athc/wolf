package com.athc.map.controller

import com.athc.map.model.HitokotoParam
import com.athc.map.service.HitokotoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author jjj
 * @date 2020/8/25
 * @since JDK1.8
 */
@RestController
@RequestMapping("/hitokoto")
class HitokotoController(
    private val hitokotoService: HitokotoService
) {

  @GetMapping("/test")
  fun content(param: HitokotoParam) = hitokotoService.content(param)
}