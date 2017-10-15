package ro.jtonic.handson.dsl.poi

import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import ro.jtonic.handson.exception.ExportException
import java.io.FileOutputStream
import java.io.IOException

/**
 * Created by Antonel Ernest Pazargic on 14/10/2017.
 * @author Antonel Ernest Pazargic
 */

object WorkbookBuilder {
    fun build(fileName: String, init: WORKBOOK.() -> Unit) = WORKBOOK(fileName).apply(init)
}

abstract class ITEM(protected val name: String = "") {

    protected var children = mutableListOf<ITEM>()

    protected fun <E : ITEM> doInit(child: E, init: E.() -> Unit) {
        child.init()
        children.add(child)
    }
}

class WORKBOOK(private val fileName: String) : ITEM() {

    fun sheet(name: String, init: SHEET.() -> Unit) = doInit(SHEET(name), init)

    operator fun invoke() {

        val workbook = XSSFWorkbook() as Workbook
        for (sheet in children) {
            when (sheet) {
                is SHEET -> sheet.create(workbook)
                else -> throw RuntimeException("Cannot create sheets")
            }
        }
        try {
            FileOutputStream(fileName).use { outputStream -> workbook.write(outputStream) }
        } catch (e: IOException) {
            throw ExportException("Cannot export data into ms file $fileName")
        }
    }
}

class SHEET(name: String) : ITEM(name) {

    fun row(no: Int, init: ROW.() -> Unit) = doInit(ROW(no), init)

    internal fun create(workbook: Workbook) {
        val wbSheet = workbook.createSheet(name)!!
        for (row in children) {
            when (row) {
                is ROW -> row.create(wbSheet)
                else -> throw RuntimeException("row cannot be created")
            }
        }
    }

}

class ROW(private val no: Int) : ITEM() {

    fun cell(no: Int, init: CELL.() -> Unit) = doInit(CELL(no), init)

    internal fun create(wbSheet: Sheet) {
        val wbRow = wbSheet.createRow(no)!!
        for (cell in children) {
            when (cell) {
                is CELL -> cell.create(wbRow)
                else -> throw RuntimeException("Cannot create cell")
            }
        }
    }

}

class CELL(private val no: Int) : ITEM() {

    var value = ""

    internal fun create(wbRow: Row) {
        wbRow.createCell(no)!!.setCellValue(value)
    }
}

