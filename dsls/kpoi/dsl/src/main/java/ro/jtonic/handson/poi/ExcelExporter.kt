package ro.jtonic.handson.poi

import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import ro.jtonic.handson.exception.ExportException
import java.io.FileOutputStream
import java.io.IOException

object ExcelExporter {

    fun exportToExcel(data: Array<Array<out Any>>, fileName: String? = "./PersonsKt.xlsx") {
        val workbook = XSSFWorkbook() as Workbook
        val sheet = workbook.createSheet("Persons")!!
        for ((rowNum, datatype) in data.withIndex()) {
            val row = sheet.createRow(rowNum)!!
            for ((colNum, field) in datatype.withIndex()) {
                val cell = row.createCell(colNum)!!
                if (field is String) {
                    cell.setCellValue(field)
                } else if (field is Int) {
                    cell.setCellValue(field.toDouble())
                }
            }
        }

        try {
            FileOutputStream(fileName).use { outputStream -> workbook.write(outputStream) }
        } catch (e: IOException) {
            throw ExportException("Cannot export data into ms file $fileName")
        }
    }
}


fun main(args: Array<String>) {
    val data = arrayOf(
            arrayOf("No", "Name", "Age"),
            arrayOf("1", "Antonel", 47),
            arrayOf("2", "Irina", 27),
            arrayOf("3", "Liviu", 33),
            arrayOf("4", "Roxana", 31),
            arrayOf("5", "Bogdan", 27)
    )
    println("Creating persons excel file")
    ExcelExporter.exportToExcel(data)
    println("Done!!!")
}
