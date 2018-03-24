package ro.jtonic.handson.springbapp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.Bean
import ro.jtonic.handson.springbapp.client.dictionary.DictionaryFeignClient
import ro.jtonic.handson.springbapp.client.hr.HrFeignClient
import ro.jtonic.handson.springbapp.client.marvel.MarvelFeignClient
import ro.jtonic.handson.springbapp.services.impl.DictionaryService

/**
 * Created by Antonel Ernest Pazargic on 25/10/2017.
 * @author Antonel Ernest Pazargic
 */
@SpringBootApplication
class Application {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val web = System.getProperty("web")?.toBoolean() ?: false
            SpringApplicationBuilder().web(web).sources(Application::class.java).build(*args).run()
        }
    }

    @Autowired
    private lateinit var dictionaryService: DictionaryService

    @Autowired
    private lateinit var dictionaryFeignClient: DictionaryFeignClient

    @Autowired
    private lateinit var hrFeignClient: HrFeignClient

    @Autowired
    private lateinit var marvelFeignClient: MarvelFeignClient

    @Bean
    fun applicationRunner() =
            ApplicationRunner { args ->
                println("".padStart(80, '='))
                println("Application is running....")
                println("Arguments = $args")
                println("".padStart(80, '='))

                if (System.getProperty("client")?.toBoolean() == true) {
                    val employees = hrFeignClient.getEmployees()
                    employees.forEach(::println)
                    assert(employees.size == 2)

                    val deaf = dictionaryService.findWord("deaf")
                    println("deaf = $deaf")

                    val deaf2 = dictionaryFeignClient.findWord("deaf")
                    assert(deaf == deaf2)

                    /*
                                    val characters = marvelFeignClient.findCharacters(limit = 2)
                                    println(characters)
                    */
                }
            }
}
