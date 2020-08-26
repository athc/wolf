package com.athc.map.model

import java.util.*

/**
 * @author jjj
 * @date 2020/8/26
 * @since JDK1.8
 */
class WeatherInfo : GaodeBaseResponse() {
  var count: String? = null
  var lives: List<Lives>? = null
  var forecasts: List<Forecasts>? = null
}

class Lives {
  var province: String? = null
  var city: String? = null
  var adcode: String? = null
  var weather: String? = null
  var temperature: String? = null
  var winddirection: String? = null
  var windpower: String? = null
  var humidity: String? = null
  var reporttime: String? = null

}

class Forecasts {
  var city: String? = null
  var adcode: String? = null
  var province: String? = null
  var reporttime: String? = null
  var casts: List<Casts>? = null

}

class Casts {
  var date: String? = null
  var week: String? = null
  var dayweather: String? = null
  var nightweather: String? = null
  var daytemp: String? = null
  var nighttemp: String? = null
  var daywind: String? = null
  var nightwind: String? = null
  var daypower: String? = null
  var nightpower: String? = null

}