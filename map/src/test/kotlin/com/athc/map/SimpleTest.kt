package com.athc.map

import com.athc.common.util.Generator
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

/**
 * @author jjj
 * @date 2020/8/19
 * @since JDK1.8
 */
class SimpleTest {

  @Test
  fun simpleTest() {
    val res = ObjectMapper().readValue("[{\"id\":11647559,\"orderId\":\"493470378992095232\",\"tradeId\":\"493471009823797248\",\"fee\":0.0014070495500,\"pairCode\":\"BBC_USDT\",\"orderType\":1,\"tradeCoinKey\":\"HnS9FQKvXnOEO5z9sbzy1HbzooRqLGDd\",\"priceCoinKey\":\"iMvEbiYyo5dICc5Z3w9eFnQQAfP0yi1H\",\"price\":1.7777000000,\"quantity\":0.7915000000,\"amounts\":1.4070495500,\"createdAt\":1597819122621,\"icon\":\"publics/20200421/eb975806-4dba-42e1-9948-7e303d4dbcc2.png\"},{\"id\":11647539,\"orderId\":\"493470378992095232\",\"tradeId\":\"493470921248485385\",\"fee\":0.1635484000000,\"pairCode\":\"BBC_USDT\",\"orderType\":1,\"tradeCoinKey\":\"HnS9FQKvXnOEO5z9sbzy1HbzooRqLGDd\",\"priceCoinKey\":\"iMvEbiYyo5dICc5Z3w9eFnQQAfP0yi1H\",\"price\":1.7777000000,\"quantity\":92.0000000000,\"amounts\":163.5484000000,\"createdAt\":1597819101503,\"icon\":\"publics/20200421/eb975806-4dba-42e1-9948-7e303d4dbcc2.png\"},{\"id\":11563687,\"orderId\":\"491990490430869504\",\"tradeId\":\"491998179076616198\",\"fee\":0.0079024920000,\"pairCode\":\"BBC_USDT\",\"orderType\":1,\"tradeCoinKey\":\"HnS9FQKvXnOEO5z9sbzy1HbzooRqLGDd\",\"priceCoinKey\":\"iMvEbiYyo5dICc5Z3w9eFnQQAfP0yi1H\",\"price\":1.5600000000,\"quantity\":5.0657000000,\"amounts\":7.9024920000,\"createdAt\":1597467972407,\"icon\":\"publics/20200421/eb975806-4dba-42e1-9948-7e303d4dbcc2.png\"},{\"id\":11437595,\"orderId\":\"489059061489242112\",\"tradeId\":\"489059899402104850\",\"fee\":0.0825595006500,\"pairCode\":\"BBC_USDT\",\"orderType\":1,\"tradeCoinKey\":\"HnS9FQKvXnOEO5z9sbzy1HbzooRqLGDd\",\"priceCoinKey\":\"iMvEbiYyo5dICc5Z3w9eFnQQAfP0yi1H\",\"price\":1.1639000000,\"quantity\":70.9335000000,\"amounts\":82.5595006500,\"createdAt\":1596767431942,\"icon\":\"publics/20200421/eb975806-4dba-42e1-9948-7e303d4dbcc2.png\"},{\"id\":11211699,\"orderId\":\"484344652162416640\",\"tradeId\":\"484349306921299974\",\"fee\":0.0285986480000,\"pairCode\":\"BBC_USDT\",\"orderType\":1,\"tradeCoinKey\":\"HnS9FQKvXnOEO5z9sbzy1HbzooRqLGDd\",\"priceCoinKey\":\"iMvEbiYyo5dICc5Z3w9eFnQQAfP0yi1H\",\"price\":0.7600000000,\"quantity\":37.6298000000,\"amounts\":28.5986480000,\"createdAt\":1595644339176,\"icon\":\"publics/20200421/eb975806-4dba-42e1-9948-7e303d4dbcc2.png\"},{\"id\":11205851,\"orderId\":\"481436709163143168\",\"tradeId\":\"484112374593237013\",\"fee\":0.0321174450000,\"pairCode\":\"BBC_USDT\",\"orderType\":1,\"tradeCoinKey\":\"HnS9FQKvXnOEO5z9sbzy1HbzooRqLGDd\",\"priceCoinKey\":\"iMvEbiYyo5dICc5Z3w9eFnQQAfP0yi1H\",\"price\":0.7300000000,\"quantity\":43.9965000000,\"amounts\":32.1174450000,\"createdAt\":1595587850107,\"icon\":\"publics/20200421/eb975806-4dba-42e1-9948-7e303d4dbcc2.png\"},{\"id\":11197433,\"orderId\":\"481436652187701248\",\"tradeId\":\"483793812397764608\",\"fee\":0.0216742775000,\"pairCode\":\"BBC_USDT\",\"orderType\":1,\"tradeCoinKey\":\"HnS9FQKvXnOEO5z9sbzy1HbzooRqLGDd\",\"priceCoinKey\":\"iMvEbiYyo5dICc5Z3w9eFnQQAfP0yi1H\",\"price\":0.7225000000,\"quantity\":29.9990000000,\"amounts\":21.6742775000,\"createdAt\":1595511898961,\"icon\":\"publics/20200421/eb975806-4dba-42e1-9948-7e303d4dbcc2.png\"},{\"id\":11166947,\"orderId\":\"481436652187701248\",\"tradeId\":\"481445975446007808\",\"fee\":7.225000E-7,\"pairCode\":\"BBC_USDT\",\"orderType\":1,\"tradeCoinKey\":\"HnS9FQKvXnOEO5z9sbzy1HbzooRqLGDd\",\"priceCoinKey\":\"iMvEbiYyo5dICc5Z3w9eFnQQAfP0yi1H\",\"price\":0.7225000000,\"quantity\":0.0010000000,\"amounts\":0.0007225000,\"createdAt\":1594952131011,\"icon\":\"publics/20200421/eb975806-4dba-42e1-9948-7e303d4dbcc2.png\"},{\"id\":11160551,\"orderId\":\"480545387321528320\",\"tradeId\":\"480904164071714819\",\"fee\":0.0018192550000,\"pairCode\":\"BBC_USDT\",\"orderType\":1,\"tradeCoinKey\":\"HnS9FQKvXnOEO5z9sbzy1HbzooRqLGDd\",\"priceCoinKey\":\"iMvEbiYyo5dICc5Z3w9eFnQQAfP0yi1H\",\"price\":0.7225000000,\"quantity\":2.5180000000,\"amounts\":1.8192550000,\"createdAt\":1594822953113,\"icon\":\"publics/20200421/eb975806-4dba-42e1-9948-7e303d4dbcc2.png\"},{\"id\":10750351,\"orderId\":\"460928981995110400\",\"tradeId\":\"460947486471630851\",\"fee\":0.0217504008000,\"pairCode\":\"BBC_USDT\",\"orderType\":1,\"tradeCoinKey\":\"HnS9FQKvXnOEO5z9sbzy1HbzooRqLGDd\",\"priceCoinKey\":\"iMvEbiYyo5dICc5Z3w9eFnQQAfP0yi1H\",\"price\":0.4968000000,\"quantity\":43.7810000000,\"amounts\":21.7504008000,\"createdAt\":1590064910396,\"icon\":\"publics/20200421/eb975806-4dba-42e1-9948-7e303d4dbcc2.png\"}]", List::class.java)
    res.stream().map { it as Map<String, Any> }
        .let {
          it
        }
        .mapToDouble { it.get("amounts")?.toString()?.toDouble() ?: 0.0 }.sum().let {
          it
        }
  }

  @Test
  fun testGenerator() {
    Generator.generatorOfDigit().generate(10).let {
      Assertions.assertTrue(it.length == 10)
    }
  }

  @Test
  fun testEx() {
    val executor = ScheduledThreadPoolExecutor(5)
    executor.schedule({
      println("线程名称：${Thread.currentThread().name}")
    }, 1000L, TimeUnit.MILLISECONDS)
    println("线程名称：${Thread.currentThread().name}")
    Thread.sleep(2000L)
  }

}