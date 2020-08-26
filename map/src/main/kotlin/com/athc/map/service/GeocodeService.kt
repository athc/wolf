package com.athc.map.service

import com.athc.map.model.*

/**
 * @author jjj
 * @date 2020/8/21
 * @since JDK1.8
 */
interface GeocodeService {

  /**
   * @url https://restapi.amap.com/v3/geocode/regeo?parameters
   * 地理逆地理编码
   */
  fun geo(param: GeocodeGeoParam): GeocodeGeo

  /**
   * @url https://restapi.amap.com/v3/geocode/regeo?parameters
   * 逆地理编码
   */
  fun regeo(param: GeocodeRegeoParam): GeocodeRegeo


  /**
   * 根据ip定位
   */
  fun ip(param: IpParam): IPAddress

  /**
   * 步行路径规划
   */
  fun directionWalking(url: String)

  /**
   *  天气查询
   */
  fun weatherWeatherInfo(param: WeatherInfoParam): WeatherInfo
}