package com.athc.excel.model

data class ExcelSheetItem(
    /**
     * 工作表名称
     */
    val name: String,

    /**
     * 内容
     */
    val rows: List<Map<String, Any?>>,

    /**
     * 标题
     */
    var title: Map<String, String> = emptyMap()
)
