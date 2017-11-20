package ro.jtonic.handson.springbapp

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

/**
 * Created by Antonel Ernest Pazargic on 25/10/2017.
 * @author Antonel Ernest Pazargic
 */
@SpringBootApplication
class Application {

    @Bean
    fun applicationRunner() =
        ApplicationRunner { args ->
            println("".padStart(80, '='))
            println("Application is running....")
            println("Arguments = $args")
            println("".padStart(80, '='))
        }
}

fun main(args: Array<String>) {
  SpringApplication.run(Application::class.java, *args)
}
