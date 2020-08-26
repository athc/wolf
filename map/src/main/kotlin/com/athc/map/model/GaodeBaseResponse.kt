package com.athc.map.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

/**
 * @author jjj
 * @date 2020/8/20
 * @since JDK1.8
 */
@JsonIgnoreProperties(ignoreUnknown = true)
open class GaodeBaseResponse(
    val status: String = "",
    val info: String = "",
    val infocode: String = ""
)

@JsonIgnoreProperties(ignoreUnknown = true)
open class GaodeBaseParam(
    val output: String = "JSON",
    var key: String = ""
) {
}

