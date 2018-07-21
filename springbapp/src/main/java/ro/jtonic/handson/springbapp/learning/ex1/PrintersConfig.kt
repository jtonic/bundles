package ro.jtonic.handson.springbapp.learning.ex1

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by Antonel Ernest Pazargic on 21/07/2018.
 * @author Antonel Ernest Pazargic
 */
@Configuration
class PrintersConfig {

    @Bean
    fun minolta() = Minolta()

    @Bean
    fun cannon() = Cannon()

    @Bean
    fun xerox() = Xerox()

    @Bean(HIGH_END_PRINTERS)
    fun highEndPrinters() = listOf(minolta(), xerox())

    @Bean(LOW_END_PRINTERS)
    fun lowEndPrinters() = listOf(cannon())

}

const val HIGH_END_PRINTERS = "highEndPrinters"
const val LOW_END_PRINTERS = "lowEndPrinters"

