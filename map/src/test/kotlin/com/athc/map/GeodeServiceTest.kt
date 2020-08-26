package com.athc.map

import com.athc.common.util.logger
import com.athc.map.config.GaodeMapProperties
import com.athc.map.config.MapAutoConfig
import com.athc.map.model.GeocodeGeoParam
import com.athc.map.model.GeocodeRegeoParam
import com.athc.map.model.IpParam
import com.athc.map.model.WeatherInfoParam
import com.athc.map.service.GeocodeService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@SpringBootTest(classes = [
  MapAutoConfig::class
], properties = ["application.yml"])
@TestPropertySource("classpath:application.yml")
class GeodeServiceTest(
    @Autowired
    private val properties: GaodeMapProperties,
    @Autowired
    private val geocodeService: GeocodeService
) {

  @Value("\${gaode.key}")
  private val key: String = ""

  @Test
  fun geo() {
    val res = geocodeService.geo(
        GeocodeGeoParam(
            address = "成都市香年广场T3栋"
        )
    )
    logger.debug(res.toString())
  }

  @Test
  fun regeo() {
    //104.06792346,30.67994285
    //104.066306,30.544269

    val res = geocodeService.regeo(
        GeocodeRegeoParam(
            location = "104.066306,30.544269"
        )
    )
    logger.debug(res.toString())
  }

  @Test
  fun ip() {
    val res = geocodeService.ip(
        IpParam(
            ip = "52.221.150.28"
        )
    )
    logger.debug(res.toString())
  }

  @Test
  fun weatherWeatherInfo() {
    val res = geocodeService.weatherWeatherInfo(
        WeatherInfoParam(
            city = "510107",
            extensions = "all"
        )
    )
    logger.debug(res.toString())
  }
}