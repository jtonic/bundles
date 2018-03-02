package ro.jtonic.handson.springboot2

import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder

/**
 * Created by Antonel Ernest Pazargic on 02/03/2018.
 * @author Antonel Ernest Pazargic
 */
@SpringBootApplication
class SpringBoot2App {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplicationBuilder()
                    .web(WebApplicationType.NONE)
                    .main(SpringBoot2App::class.java)
                    .build(*args)
                    .run {
                        println("It is running...")
                    }
        }
    }
/*
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplicationBuilder()
                    .sources(SpringBoot2App::class.java)
                    .run(*args)
        }
    }
*/
}
