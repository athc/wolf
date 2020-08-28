package com.athc.map.config

import org.springframework.cache.Cache
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.ehcache.EhCacheCache
import org.springframework.cache.ehcache.EhCacheCacheManager
import org.springframework.context.annotation.Configuration


/**
 * @author jjj
 * @date 2020/8/19
 * @since JDK1.8
 * 不存在的缓存命名空间动态处理
 * 其他配置在ehcache.xml 文件
 */
@EnableCaching
@Configuration
open class MyEhCacheCacheManager : EhCacheCacheManager() {

  override fun getMissingCache(name: String): Cache {
    var cache: Cache? = super.getMissingCache(name)
    if (cache == null) {
      val ehcache = super.getCacheManager()!!.addCacheIfAbsent(name)
      cache = EhCacheCache(ehcache)
    }
    return cache
  }
}