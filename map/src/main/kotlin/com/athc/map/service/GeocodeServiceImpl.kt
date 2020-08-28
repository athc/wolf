package com.athc.map.service

import com.athc.common.util.queryString
import com.athc.map.config.GaodeMapProperties
import com.athc.map.constant.GaodeUrl
import com.athc.map.model.*
import com.athc.map.provider.AbstractHttpClientProvider
import org.springframework.stereotype.Service

@Service
class GeocodeServiceImpl(
    private val gaodeProvider: AbstractHttpClientProvider,
    private val properties: GaodeMapProperties
) : GeocodeService {
  /**
   * @url https://restapi.amap.com/v3/geocode/geo?parameters
   * 地理逆地理编码
   */
  override fun geo(param: GeocodeGeoParam): GeocodeGeo {
    param.key = properties.key
    val url = GaodeUrl.geocode_geo + "?${param.queryString()}"
    val r = Request(method = "post", url = url)
    return gaodeProvider.execute(r, GeocodeGeo::class.java)
  }

  /**
   * @url https://restapi.amap.com/v3/geocode/regeo?parameters
   * 地理/逆地理编码
   */
  override fun regeo(param: GeocodeRegeoParam): GeocodeRegeo {
    param.key = properties.key
    val url = GaodeUrl.geocode_regeo + "?${param.queryString()}"
    val r = Request(url = url)
    return gaodeProvider.execute(r, GeocodeRegeo::class.java)
  }

  /**
   * 根据ip定位
   */
  override fun ip(param: IpParam): IPAddress {
    param.key = properties.key
    val url = GaodeUrl.IP + "?${param.queryString()}"
    val r = Request(url = url)
    return gaodeProvider.execute(r, IPAddress::class.java)
  }

  /**
   * 步行路径规划
   */
  override fun directionWalking(url: String) {
    TODO("Not yet implemented")
  }

  /**
   * 步行路径规划
   */
  override fun weatherWeatherInfo(param: WeatherInfoParam): WeatherInfo {
    param.key = properties.key
    val url = GaodeUrl.weather_weatherInfo + "?${param.queryString()}"
    val r = Request(url = url)
    return gaodeProvider.execute(r, WeatherInfo::class.java)
  }
}