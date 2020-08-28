package com.athc.excel.component

import com.athc.excel.model.ExcelSheetItem
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.DateUtil
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.text.DecimalFormat


@Component
class PoiExcelHandler : IExcelHandler {

  override fun readXssf(inputStream: InputStream): List<ExcelSheetItem> {
    return readWorkbook(XSSFWorkbook(inputStream))
  }

  override fun readXssfWithHeader(inputStream: InputStream): List<ExcelSheetItem> {
    return mergeHeader(readXssf(inputStream))
  }

  override fun readXssf(filePath: String): List<ExcelSheetItem> {
    return readWorkbook(XSSFWorkbook(File(filePath)))
  }

  override fun readXssfWithHeader(filePath: String): List<ExcelSheetItem> {
    return mergeHeader(readXssf(filePath))
  }

  override fun writeXssf(filePath: String, sheets: List<ExcelSheetItem>, titleValueAsKey: Boolean?) {
    val workbook = writeWorkbook(sheets, titleValueAsKey)
    val out = FileOutputStream(filePath)
    workbook.write(out)
    out.close()
  }

  /**
   * 导出数据写入流
   *
   * @param outputStream 输出流
   */
  override fun writeXssfOutputStream(outputStream: OutputStream, sheets: List<ExcelSheetItem>, titleValueAsKey: Boolean?) {
    val workbook = writeWorkbook(sheets, titleValueAsKey)
    workbook.write(outputStream)
    outputStream.close()
  }

  private fun mergeHeader(data: List<ExcelSheetItem>): List<ExcelSheetItem> {
    return data.map { item ->
      ExcelSheetItem(
          name = item.name,
          rows = when (item.rows.size) {
            0, 1 -> listOf()
            else -> {
              val header = item.rows[0]
              item.rows.subList(1, item.rows.size).map { row ->
                val rowData = mutableMapOf<String, Any?>()
                if (row.isNotEmpty()) {
                  header.forEach { (t, u) ->
                    rowData[u.toString()] = row.getOrDefault(t, null)
                  }
                }
                rowData
              }.filter { r -> r.isNotEmpty() }
            }
          },
          title = item.rows.takeIf { it.isNotEmpty() }
              ?.firstOrNull()
              ?.mapValues { it.value.takeIf { null != it }.toString() }
              ?: emptyMap()
      )
    }
  }

  /**
   * 读工作表
   */
  private fun readWorkbook(workbook: XSSFWorkbook): List<ExcelSheetItem> {
    return workbook.sheetIterator().asSequence().map { sheet ->
      ExcelSheetItem(
          name = sheet.sheetName,
          rows = sheet.rowIterator().asSequence().map { r ->
            r.cellIterator().asSequence().map { c ->
              val value = when (c.cellType) {
                CellType.STRING -> c.stringCellValue as Any
                CellType.NUMERIC ->
                  if (DateUtil.isCellDateFormatted(c)) c.dateCellValue
                  else DecimalFormat("#").format(c.numericCellValue)
                CellType.BOOLEAN -> c.booleanCellValue
                else -> ""
              }
              Pair(c.columnIndex.toString(), value)
            }.toMap()
          }.toList()
      )
    }.toList()
  }

  /**
   * HSSF 是操作Excel97-2003版本，扩展名为.xls 一个sheet最大行数65536，最大列数256
   * XSSF 是操作Excel2007版本开始，扩展名为.xlsx 一个sheet最大行数1048576，最大列数16384
   * SXSSF 是在XSSF基础上，POI3.8版本开始提供的一种支持低内存占用的操作方式，扩展名为.xlsx
   *
   * @param titleValueAsKey 标题的value作为key获取数据(默认使用标题key作为键)
   */
  private fun writeWorkbook(sheets: List<ExcelSheetItem>, titleValueAsKey: Boolean? = false): Workbook {
    val workbook = XSSFWorkbook()

    sheets.forEach {

      val sheet = workbook.createSheet(it.name)
      val header = sheet.createRow(0)

      // 未设置标题使用第一行数据作为key
      val titleValues =
          if (it.title.isNotEmpty()) it.title
          else it.rows.firstOrNull()?.mapValues { it.value.takeIf { null != it }?.toString() ?: "" }
              ?: emptyMap()

      // 存在标题才设置标题
      if (it.title.isNotEmpty()) {
        titleValues.values.forEachIndexed { index, s ->
          val cell = header.createCell(index)
          cell.setCellValue(s)
        }
      }

      // 填充数据
      it.rows.forEachIndexed { index, row ->
        // 有标题从第二行开始写数据 否则第一行开始
        val moveIndex = if (it.title.isEmpty()) 0 else 1
        val r = sheet.createRow(index + moveIndex)
        titleValues.entries.forEachIndexed { i, title ->
          val cell = r.createCell(i)
          val realKey = if (true == titleValueAsKey) title.value else title.key
          cell.setCellValue(row[realKey]?.toString())
        }
      }

      // 设置自动列宽
      for (i in titleValues.values.indices) {
        sheet.autoSizeColumn(i)
        sheet.setColumnWidth(i, sheet.getColumnWidth(i) * 17 / 10)
      }
    }

    return workbook
  }

  companion object {
    // 最大行数
    const val XSSF_MAX_ROW_NUMBER = 1048576L
  }
}