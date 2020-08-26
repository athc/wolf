package com.athc.map.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
class Hitokoto(
    var id: Long = 0,
    var uuid: String? = "",
    var hitokoto: String? = "",
    var type: String? = "",
    var from: String? = "",
    var fromWho: String? = "",
    var creator: String? = "",
    var creatorUid: Long = 0,
    var reviewer: Long = 0,
    var commitFrom: String? = "",
    var createdAt: String? = "",
    var length: Long = 0
)