package ro.jtonic.handson.springbapp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.Bean
import ro.jtonic.handson.springbapp.services.impl.DictionaryService

/**
 * Created by Antonel Ernest Pazargic on 25/10/2017.
 * @author Antonel Ernest Pazargic
 */
@SpringBootApplication
@EnableFeignClients
class Application {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.run(Application::class.java, *args)
        }
    }

    @Autowired
    private lateinit var dictionaryService: DictionaryService

    @Bean
    fun applicationRunner() =
            ApplicationRunner { args ->
                println("".padStart(80, '='))
                println("Application is running....")
                println("Arguments = $args")
                println("".padStart(80, '='))

                //            dictionaryService.findWord("Antonel")
            }

}
