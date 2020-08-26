package com.athc.map.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import io.swagger.annotations.ApiModelProperty

/**
 * @author jjj
 * @date 2020/8/20
 * @since JDK1.8
 */
@JsonIgnoreProperties(ignoreUnknown = true)
class GeocodeRegeoParam(
    @ApiModelProperty(required = true)
    val location: String = "",
    val poitype: String? = null,
    val radius: String? = null,
    val extensions: String? = null,
    val batch: Boolean = false,
    val roadlevel: Long = 0
) : GaodeBaseParam()
