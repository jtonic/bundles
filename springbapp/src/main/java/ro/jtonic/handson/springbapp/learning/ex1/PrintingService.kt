package ro.jtonic.handson.springbapp.learning.ex1

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

/**
 * Created by Antonel Ernest Pazargic on 21/07/2018.
 * @author Antonel Ernest Pazargic
 */

@Service
class PrintingService {

    @Autowired
    @Qualifier(HIGH_END_PRINTERS)
    private lateinit var highEndPrinters: List<Printable>

    @Autowired
    private lateinit var xerox: Xerox

    @Autowired
    @Qualifier(LOW_END_PRINTERS)
    private lateinit var lowEndPrinters: List<Printable>

    @Autowired
    private lateinit var allPrinters: List<Printable>


    fun print() {
        println("\nPrinting with highEndPrinters")
        println(80 * "=")
        highEndPrinters.forEach { it.print() }

        println("\nPrinting with lowEndPrinters")
        println(80 * "=")
        lowEndPrinters.forEach { it.print() }

        println("\nPrinting with xerox")
        println(80 * "=")
        xerox.print()

        println("\nPrinting with all printers")
        println(80 * "=")
        allPrinters.forEach { it.print() }

    }
}

private operator fun Int.times(str: String): String =
        StringBuffer().let {strBuf ->
                                repeat(this) { strBuf.append(str) }
                                strBuf.toString()
                            }
