package com.athc.map.model

/**
 * @author jjj
 * @date 2020/8/20
 * @since JDK1.8
 */
class Request(
    val url: String = "",
    val method: String = "get",
    val params: Map<String, String> = emptyMap()
) {


}