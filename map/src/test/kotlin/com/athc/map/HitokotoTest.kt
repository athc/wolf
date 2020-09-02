package com.athc.map

import com.athc.map.config.MyEhCacheCacheManager
import com.athc.map.model.HitokotoParam
import com.athc.map.service.HitokotoService
import net.sf.ehcache.Element
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@SpringBootTest(classes = [com.athc.map.config.MapAutoConfig::class])
@TestPropertySource("classpath:application.yml")
class HitokotoTest(
    @Autowired
    private val hitokotoService: HitokotoService,
    @Autowired
    private val cacheCacheManager: MyEhCacheCacheManager
) {

  @Value("\${gaode.key}")
  private val key: String = ""

  @Test
  fun simpleTest() {
    repeat(10) {

      val res = hitokotoService.content(HitokotoParam(
          c = "i"//,
//        encode = "text"
      ))
      Assertions.assertTrue(!res.hitokoto.isNullOrBlank())
    }
  }

  /**
   * 使用cache management 缓存数据
   */
  @Test
  fun testCache() {
    val cacheManager = cacheCacheManager.cacheManager
    cacheManager?.let {
      val cache = it.addCacheIfAbsent("cacheName")
      cache.put(Element("key", "value"))
      cache.get("key").let {
        it
      }
    }
  }
}