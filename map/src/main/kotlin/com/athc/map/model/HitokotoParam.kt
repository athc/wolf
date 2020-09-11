package com.athc.map.model

import io.swagger.annotations.ApiModelProperty
import javax.validation.constraints.NotBlank

/**
 * @author jjj
 * @date 2020/8/24
 * @since JDK1.8
 */
class HitokotoParam(

    @ApiModelProperty("句子类型 a\t动画\n" +
        "b\t漫画\n" +
        "c\t游戏\n" +
        "d\t文学\n" +
        "e\t原创\n" +
        "f\t来自网络\n" +
        "g\t其他\n" +
        "h\t影视\n" +
        "i\t诗词\n" +
        "j\t网易云\n" +
        "k\t哲学\n" +
        "l\t抖机灵\n" +
        "其他\t作为 动画 类型处理\n" +
        "可选择多个分类，例如： ?c=a&c=c")
    @field:NotBlank
    val c: String? = null,

    @ApiModelProperty("")
    val encode: String? = null,

    @ApiModelProperty("字符集")
    val charset: String? = null,

    @ApiModelProperty("调用的异步函数")
    val callback: String? = null,

    @ApiModelProperty("选择器。配合 encode=js 使用")
    val select: String? = null,

    @ApiModelProperty("返回句子的最小长度（包含）")
    val min_length: String? = null,

    @ApiModelProperty("返回句子的最大长度（包含）")
    val max_length: String? = null
)