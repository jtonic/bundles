package ro.jtonic.handson.dsl.poi

import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 14/10/2017.
 *
 * @author Antonel Ernest Pazargic
 */
class WorkbookBuilderTest {

    @Test
    fun `build a simple workbook`() {
        WorkbookBuilder.build("./Simple.xlsx") {
            sheet("Simple") {
                row(0) {
                    cell(0) {
                        value = "Kotlin DSL rules"
                    }
                }
            }
        }()
    }

    @Test
    fun `build a little bit complicated workbook`() {
        WorkbookBuilder.build("./DSL.xlsx") {
            for (sheetNo in 0..1) {
                sheet("Sheet $sheetNo") {
                    for (rowNo in 0..5) {
                        row(rowNo) {
                            for (cellNo in 0 until 10) {
                                cell(cellNo) {
                                    value = "Antonel $cellNo"
                                }
                            }
                        }
                    }
                }
            }
        }()
    }
}
