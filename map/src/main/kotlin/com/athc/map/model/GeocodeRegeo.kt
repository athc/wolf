package com.athc.map.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * @author jjj
 * @date 2020/8/20
 * @since JDK1.8
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class GeocodeRegeo(
    val regeocode: Regeocode? = null
) : GaodeBaseResponse()

@JsonIgnoreProperties(ignoreUnknown = true)
class Regeocode {
  var formatted_address: String? = null
  var addressComponent: AddressComponent? = null
  var pois: List<Pois>? = null
  var roads: List<Roads>? = null
  var roadinters: List<Roadinters>? = null
  var aois: List<Aois>? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
class AddressComponent {
  var country: String? = null
  var province: String? = null
  var city: Any? = null
  var citycode: String? = null
  var district: String? = null
  var adcode: String? = null
  var township: String? = null
  var towncode: String? = null
  var neighborhood: Neighborhood? = null
  var building: Building? = null
  var streetNumber: StreetNumber? = null
  var businessAreas: Any? = null

  class Neighborhood(
      var name: Any? = null,
      var type: Any? = null
  )

  class Building(
      var name: Any? = null,
      var type: Any? = null
  )
}

@JsonIgnoreProperties(ignoreUnknown = true)
class BusinessAreas {
  var location: String? = null
  var name: String? = null
  var id: String? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
class StreetNumber {
  var street: Any? = null
  var number: Any? = null
  var location: Any? = null
  var direction: Any? = null
  var distance: Any? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Roads {
  var id: String? = null
  var name: String? = null
  var direction: String? = null
  var distance: String? = null
  var location: String? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Pois {
  var id: String? = null
  var name: String? = null
  var type: String? = null
  var tel: String? = null
  var direction: String? = null
  var distance: String? = null
  var location: String? = null
  var address: String? = null
  var poiweight: String? = null
  var businessarea: String? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Aois {
  var id: String? = null
  var name: String? = null
  var adcode: String? = null
  var location: String? = null
  var area: String? = null
  var distance: String? = null
  var type: String? = null
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Roadinters {
  var direction: String? = null
  var distance: String? = null
  var location: String? = null
  var first_id: String? = null
  var first_name: String? = null
  var second_id: String? = null
  var second_name: String? = null
}

