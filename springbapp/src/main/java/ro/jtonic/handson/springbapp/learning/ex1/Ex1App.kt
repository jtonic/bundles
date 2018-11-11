package ro.jtonic.handson.springbapp.learning.ex1

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.Bean

/**
 * Created by Antonel Ernest Pazargic on 21/07/2018.
 * @author Antonel Ernest Pazargic
 */

@SpringBootApplication
class Ex1App(val printingService: PrintingService) {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplicationBuilder().web(WebApplicationType.SERVLET).sources(Ex1App::class.java).build().run(*args)
        }
    }

    @Bean
    fun runner() = ApplicationRunner {
        printingService.print()
    }
}


