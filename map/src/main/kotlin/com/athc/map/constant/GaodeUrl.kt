package com.athc.map.constant

/**
 * @author jjj
 * @date 2020/8/21
 * @since JDK1.8
 */
object GaodeUrl {
  const val BASE = "https://restapi.amap.com"
  const val VERSION_V3 = "/v3"
  const val VERSION_V4 = "/v4"
  const val geocode_geo = "$BASE$VERSION_V3/geocode/geo"
  const val geocode_regeo = "$BASE$VERSION_V3/geocode/regeo"
  const val direction_walking = "$BASE$VERSION_V3/direction/walking"
  const val direction_transit = "$BASE$VERSION_V3/direction/walking"
  const val direction_driving = "$BASE$VERSION_V3/direction/driving"
  const val direction_bicycling = "$BASE$VERSION_V4/direction/bicycling"
  const val distance = "$BASE$VERSION_V3/distance"
  const val config_district = "$BASE$VERSION_V3/config/district"
  const val place_text = "$BASE$VERSION_V3/place/text"
  const val place_around = "$BASE$VERSION_V3/place/around"
  const val place_polygon = "$BASE$VERSION_V3/place/polygon"
  const val place_detail = "$BASE$VERSION_V3/place/detail"
  const val IP = "$BASE$VERSION_V3/ip"
  const val batch = "$BASE$VERSION_V3/batch"
  const val staticmap = "$BASE$VERSION_V3/staticmap"
  const val assistant_coordinate_convert = "$BASE$VERSION_V3/assistant/coordinate/convert"
  const val weather_weatherInfo = "$BASE$VERSION_V3/weather/weatherInfo"
  const val assistant_inputtips = "$BASE$VERSION_V3/assistant/inputtips"
}