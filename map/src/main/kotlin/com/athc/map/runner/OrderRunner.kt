package com.athc.map.runner

import com.athc.common.util.ThreadPool
import com.athc.common.util.logger
import com.athc.map.model.HitokotoParam
import com.athc.map.service.HitokotoService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit
import kotlin.RuntimeException

/**
 * @author jjj
 * @date 2020/9/11
 * @since JDK1.8
 */
@Component
class OrderRunner(
    private val hitokotoService: HitokotoService
) : CommandLineRunner {

  override fun run(vararg args: String) {
//    val pool = ThreadPool.scheduledExecutor()
//    repeat(20) {
//      pool.schedule({
//        try {
//          hitokotoService.content(HitokotoParam())
//        } catch (e: RuntimeException) {
//          e.localizedMessage.logger.info(this.toString())
//        }
//      }, 1L + 1 * it, TimeUnit.SECONDS)
//    }
  }

}