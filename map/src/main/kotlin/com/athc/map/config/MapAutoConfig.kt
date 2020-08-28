package com.athc.map.config

import com.athc.map.provider.GaodeProvider
import com.athc.map.provider.HitokotoProvider
import okhttp3.OkHttpClient
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

/**
 * @author jjj
 * @date 2020/8/19
 * @since JDK1.8
 */
@Configuration
@ComponentScan(basePackages = ["com.athc.map"])
open class MapAutoConfig {

  @Bean
  @ConfigurationProperties(prefix = "gaode")
  open fun gaodeMapProperties() = GaodeMapProperties()

  @Bean
  open fun okhttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .retryOnConnectionFailure(false)
        .build()
  }

  @Bean
  open fun gaodeProvider(okHttpClient: OkHttpClient) = GaodeProvider(okHttpClient)

  @Bean
  open fun hitokotoProvider(okHttpClient: OkHttpClient) = HitokotoProvider(okHttpClient)
}