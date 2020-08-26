package com.athc.map.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * @author jjj
 * @date 2020/8/20
 * @since JDK1.8
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class GeocodeGeoParam(
    val address: String = ""
) : GaodeBaseParam()

