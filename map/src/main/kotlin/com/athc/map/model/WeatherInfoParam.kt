package com.athc.map.model

import io.swagger.annotations.ApiModelProperty

/**
 * @author jjj
 * @date 2020/8/26
 * @since JDK1.8
 */
class WeatherInfoParam(
    @ApiModelProperty("输入城市的adcode，adcode信息可参考城市编码表", required = true)
    val city: String? = null,
    
    @ApiModelProperty("气象类型 base/all", required = false)
    val extensions: String? = null
) : GaodeBaseParam() {
}