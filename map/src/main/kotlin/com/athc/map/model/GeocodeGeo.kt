package com.athc.map.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * @author jjj
 * @date 2020/8/20
 * @since JDK1.8
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class GeocodeGeo(
    val count: Long = 0L,
    val geocodes: List<Geocode>? = null
) : GaodeBaseResponse() {

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Geocode(
    val formattedAddress: String = "",
    val country: String = "",
    val province: String = "",
    val citycode: String = "",
    val city: String = "",
    val district: String = "",
    val township: List<String> = emptyList(),
    val neighborhood: Neighborhood? = null,
    var building: Building? = null,
    var adcode: String = "",
    var street: Any? = null,
    var number: Any? = null,
    var location: String = "",
    var level: String = ""
) {

  class Neighborhood(
      var name: List<String>? = null,
      var type: List<String>? = null
  )

  class Building(
      var name: List<String>? = null,
      var type: List<String>? = null
  )
}




