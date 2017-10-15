package ro.jtonic.handson.poi

/**
 * Created by Antonel Ernest Pazargic on 14/10/2017.
 * @author Antonel Ernest Pazargic
 */
object TestKt {

    @JvmStatic
    fun main(args: Array<String>) {
        val data = arrayOf(
                arrayOf("No", "Name", "Age"),
                arrayOf("1", "Antonel", 47),
                arrayOf("2", "Irina", 27),
                arrayOf("3", "Liviu", 33),
                arrayOf("4", "Roxana", 31),
                arrayOf("5", "Bogdan", 27)
        )
        ExcelExporter.exportToExcel(data)
        println("Data was successfully exported into an excel file")
    }
}
