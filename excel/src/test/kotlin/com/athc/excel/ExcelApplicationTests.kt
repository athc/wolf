package com.athc.excel

import com.athc.common.util.logger
import com.athc.excel.component.PoiExcelHandler
import com.athc.excel.config.ExcelAutoConfig
import com.athc.excel.model.ExcelSheetItem
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.FileInputStream
import java.io.FileOutputStream

@SpringBootTest(classes = [ExcelAutoConfig::class])
class ExcelApplicationTests(
    @Autowired
    private val excelHandler: PoiExcelHandler
) {

  @Test
  fun testReadExcel() {
    val sheets = excelHandler.readXssf("/Users/dujf/Desktop/testWrite.xlsx")
    Assertions.assertTrue(sheets.size == 6)
  }

  @Test
  fun testReadExcelInputStream() {
    val sheets = excelHandler.readXssf(FileInputStream("/Users/dujf/Desktop/AMap_adcode_citycode.xlsx"))
    sheets.forEach {
      val titles = it.rows[0]
      val cityName = titles.getOrDefault("0", "")
      val code = titles.getOrDefault("1", "")
      val subCode = titles.getOrDefault("2", "")
      it.rows.subList(1, it.rows.size).forEach {
        logger.info("""
          $cityName：${it.getOrDefault("0", "")} ==== $code: ${it.getOrDefault("1", "")} ==== $subCode: ${it.getOrDefault("2", "")}
        """.trimIndent())
      }
    }

  }

  @Test
  fun readXssfWithHeader() {
    val sheets = excelHandler.readXssfWithHeader("/Users/dujf/Desktop/AMap_adcode_citycode.xlsx")
    sheets.forEach { item ->
      item.rows.forEach { data ->
        var s = ""
        item.title.forEach { title ->
          data.getOrDefault(title.value, "").let {
            s = s + "===" + title.value + ":" + it?.toString()
          }
        }
        logger.info(s)
      }
    }
  }

  @Test
  fun writeXssf() {
    val sheets = excelHandler.readXssfWithHeader("/Users/dujf/Desktop/AMap_adcode_citycode.xlsx")
    sheets.forEach {
      it.apply {
        it.title = mapOf(
            "中文名" to "名称",
            "adcode" to "adcode",
            "citycode" to "citycode"
        )
      }
    }
    excelHandler.writeXssf("/Users/dujf/Desktop/test_write.xlsx", sheets)
  }

  @Test
  fun writeXssfWithData() {
    val sheets = ArrayList<ExcelSheetItem>()
    val item = ExcelSheetItem(
        name = "student",
        rows = arrayListOf(mapOf(
            "age" to "1",
            "name" to "张三",
            "mobile" to "15182719913"
        )).apply {
          repeat(10) {
            this.add(mapOf(
                "age" to "1",
                "name" to "张三",
                "mobile" to "15182719913"
            ))
          }
        }
    )
    sheets.add(item)
    excelHandler.writeXssf("/Users/dujf/Desktop/user_info.xlsx", sheets)
  }

  @Test
  fun writeXssfOutputStream() {
    val sheets = excelHandler.readXssfWithHeader("/Users/dujf/Desktop/在场车辆列表.xlsx")
    val outputStream = FileOutputStream("/Users/dujf/Desktop/testWrite.xlsx")
    val item = sheets[0]
    val s = sheets.toMutableList()
    repeat(5) {
      s.add(item.copy(
          name = item.name + it
      ))
    }
    excelHandler.writeXssfOutputStream(outputStream, s, true)
  }
}
