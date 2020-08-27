package com.athc.excel.component

import com.athc.excel.model.ExcelSheetItem
import java.io.InputStream
import java.io.OutputStream

interface IExcelHandler {

  /**
   * 根据文件路径读取文件
   *
   * @param filePath 文件路径
   */
  fun readXssf(filePath: String): List<ExcelSheetItem>

  /**
   * 根据文件路径读取文件带标题
   *
   * @param filePath 文件路径
   */
  fun readXssfWithHeader(filePath: String): List<ExcelSheetItem>

  /**
   * 根据流读取文件
   *
   * @param filePath 文件路径
   */
  fun readXssf(inputStream: InputStream): List<ExcelSheetItem>

  /**
   * 根据流读取文件带标题
   *
   * @param filePath 文件路径
   */
  fun readXssfWithHeader(inputStream: InputStream): List<ExcelSheetItem>

  /**
   * 导出数据到到指定文件
   *
   * @param filePath 文件路径
   */
  fun writeXssf(filePath: String, sheets: List<ExcelSheetItem>, titleValueAsKey: Boolean?=false)

  /**
   * 导出数据返回流
   *
   * @param filePath 文件路径
   */
  fun writeXssfOutputStream(outputStream: OutputStream, sheets: List<ExcelSheetItem>, titleValueAsKey: Boolean? = false)
}