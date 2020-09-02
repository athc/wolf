# 高德地图接口对接

## 第三方请求客户端封装

## ehcache 缓存使用

1） 缓存依赖
```gradle
  compile("org.springframework.boot:spring-boot-starter-cache:$spring_boot_version")
  compile("net.sf.ehcache:ehcache:$ehcache_version")
```
2) 缓存配置

```yml
spring:
  cache:
      type: ehcache //使用ehcache 缓存
      ehcache:
        config: classpath:/ehcache.xml //缓存配置文件
```

常用的缓存空间缓存配置
```text
 <cache
            name="twoSeconds"  // 缓存空间名称
            eternal="false"    // 对象是否永不过期
            maxElementsInMemory="100"  // 内存中最大缓存对象数
            overflowToDisk="false"
            diskPersistent="false"
            timeToIdleSeconds="2" // 对象处于空闲状态的最长时间
            timeToLiveSeconds="2"  // 缓存有效时间
            memoryStoreEvictionPolicy="LRU" // 内存不足缓存清理策略
    />
```

未配置的缓存空间可以动态添加，使用默认的缓存配置
```kotlin
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
```

## 常用缓存注解说明

* @EnableCaching // 启动缓存

* @Cacheable // 缓存
```kotlin
 @Cacheable(
 cacheNames = ["twoSeconds"], // 缓存命名空间（必选参数）
 key = "'content'", // 缓存key  支持 SpEL 表达式
 condition = "", // 缓存生效条件
 unless = "", // 缓存排除条件
 cacheManager = "", // 缓存管理器
 cacheResolver = "" // 缓存处理器
)
```

* @CacheEvict // 移除缓存
```kotlin
 @CacheEvict(
 cacheNames = ["twoSeconds"], // 缓存命名空间（必选参数）
 key = "'content'", // 缓存key  支持 SpEL 表达式
 condition = "", // 缓存生效条件
 cacheManager = "", // 缓存管理器
 cacheResolver = "", // 缓存处理器
 allEntries = true // 是否移除缓存空间全部缓存  true 会忽略指定的缓存key
)
```

* @CacheCut // 修改缓存
```kotlin
 @CacheCut(
 cacheNames = ["twoSeconds"], // 缓存命名空间（必选参数）
 key = "'content'", // 缓存key  支持 SpEL 表达式
 condition = "", // 缓存生效条件
 unless = "", // 缓存排除条件
 cacheManager = "", // 缓存管理器
 cacheResolver = "" // 缓存处理器
)
```

* @Caching // 缓存组

## 接口缓存数据
```kotlin
// 获取缓存管理器
 val cacheManager = cacheCacheManager.cacheManager
    cacheManager?.let {
      // 获取缓存空间
      val cache = it.addCacheIfAbsent("cacheName")
      // 缓存数据
      cache.put(Element("key", "value"))
      // 读取缓存数据
      cache.get("key").let {
        it
      }
    }
  }
``` 

