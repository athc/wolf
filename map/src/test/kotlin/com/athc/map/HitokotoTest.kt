package com.athc.map

import com.athc.map.model.HitokotoParam
import com.athc.map.service.HitokotoService
import com.athc.map.service.HitokotoServiceImpl
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@SpringBootTest(classes = [com.athc.map.config.MapAutoConfig::class, HitokotoServiceImpl::class])
@TestPropertySource("classpath:application.yml")
class HitokotoTest(
    @Autowired
    private val hitokotoService: HitokotoService
) {

  @Value("\${gaode.key}")
  private val key: String = ""

  @Test
  fun simpleTest() {
    val res = hitokotoService.content(HitokotoParam(
        c = "i"//,
//        encode = "text"
    ))
    Assertions.assertTrue(!res.hitokoto.isNullOrBlank())
  }
}