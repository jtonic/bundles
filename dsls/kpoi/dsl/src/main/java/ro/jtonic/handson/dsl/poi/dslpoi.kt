package ro.jtonic.handson.dsl.poi

import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import ro.jtonic.handson.exception.ExportException
import java.io.FileOutputStream
import java.io.IOException
import java.lang.annotation.Inherited

/**
 * Created by Antonel Ernest Pazargic on 14/10/2017.
 * @author Antonel Ernest Pazargic
 */

@DslMarker
@Inherited
annotation class PoiDsl

@PoiDsl
class Workbook {
    operator fun invoke(fileName: String, init: _WORKBOOK.() -> Unit) = _WORKBOOK(fileName).apply(init)()
}

@PoiDsl
abstract class ITEM(protected val name: String = "") {

    protected var children = mutableListOf<ITEM>()

    internal fun <E : ITEM> doInit(child: E, init: E.() -> Unit) {
        child.init()
        children.add(child)
    }
}

class _WORKBOOK(private val fileName: String) : ITEM() {

    operator fun invoke() {

        val workbook = XSSFWorkbook() as Workbook
        for (sheet in children) {
            when (sheet) {
                is _SHEET -> sheet.create(workbook)
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

fun _WORKBOOK.sheet(name: String, init: _SHEET.() -> Unit) = doInit(_SHEET(name), init)

class _SHEET(name: String) : ITEM(name) {

    internal fun create(workbook: Workbook) {
        val wbSheet = workbook.createSheet(name)!!
        for (row in children) {
            when (row) {
                is _ROW -> row.create(wbSheet)
                else -> throw RuntimeException("row cannot be created")
            }
        }
    }

}

fun _SHEET.row(no: Int, init: _ROW.() -> Unit) = doInit(_ROW(no), init)

class _ROW(private val no: Int) : ITEM() {

    internal fun create(wbSheet: Sheet) {
        val wbRow = wbSheet.createRow(no)!!
        for (cell in children) {
            when (cell) {
                is _CELL -> cell.create(wbRow)
                else -> throw RuntimeException("Cannot create cell")
            }
        }
    }

}

fun _ROW.cell(no: Int, init: _CELL.() -> Unit) = doInit(_CELL(no), init)

class _CELL(private val no: Int) : ITEM() {

    var value = ""

    internal fun create(wbRow: Row) {
        wbRow.createCell(no)!!.setCellValue(value)
    }
}

