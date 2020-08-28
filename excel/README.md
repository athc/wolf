excel 模块


## 读excel表 

* 支持根据文件路径或输入流读取excel表内容

```kotlin
// 读指定文件数据 支持读文件全部工作表数据
val sheets = excelHandler.readXssf("/Users/dujf/Desktop/testWrite.xlsx")
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
```

## 写excel表

* 支持根据文件路径或输出流读取excel表内容

使用示例
```kotlin
fun writeXssfWithData() {
    // 构建数据源
    val sheets = ArrayList<ExcelSheetItem>()

    val item = ExcelSheetItem(
        // 工作表名称
        name = "student",
        // 数据
        rows = arrayListOf(mapOf(
            "age" to "1",
            "name" to "张三",
            "mobile" to "15182719913"
        )),
        // 标题
        title = mapOf(
              "age" to "年龄",
              "name" to "姓名",
              "mobile" to "手机号"
            )
    )
    sheets.add(item)
    // 写入指定文件
    excelHandler.writeXssf("/Users/dujf/Desktop/user_info.xlsx", sheets)
  }
```