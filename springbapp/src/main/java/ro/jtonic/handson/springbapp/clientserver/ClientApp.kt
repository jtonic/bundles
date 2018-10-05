package ro.jtonic.handson.springbapp.clientserver

import io.kotlintest.shouldThrow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer
import org.springframework.core.io.ClassPathResource
import ro.jtonic.handson.springbapp.clientserver.annotation.Client
import ro.jtonic.handson.springbapp.clientserver.annotation.Server
import ro.jtonic.handson.springbapp.clientserver.client.dictionary.DictionaryFeignClient
import ro.jtonic.handson.springbapp.clientserver.client.hr.BusinessFeignException
import ro.jtonic.handson.springbapp.clientserver.client.hr.HrFeignClient
import ro.jtonic.handson.springbapp.clientserver.client.marvel.MarvelFeignClient
import ro.jtonic.handson.springbapp.clientserver.services.impl.DictionaryService

/**
 * Created by Antonel Ernest Pazargic on 25/10/2017.
 * @author Antonel Ernest Pazargic
 */
@SpringBootApplication
@Client
@ComponentScan(excludeFilters = [ComponentScan.Filter(value = [Server::class])])
class ClientApp {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplicationBuilder().web(false).sources(ClientApp::class.java).build(*args).run()
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

                val deaf = dictionaryService.findWord("deaf")
                println("deaf = $deaf")

                val deaf2 = dictionaryFeignClient.findWord("deaf")
                assert(deaf == deaf2)

                val employees = hrFeignClient.getEmployees(200)
                employees.forEach(::println)
                assert(employees.size == 2)

                shouldThrow<BusinessFeignException> {
                    hrFeignClient.getEmployees(400)
                }

                shouldThrow<BusinessFeignException> {
                    hrFeignClient.getEmployees(417)
                }

                val characters = marvelFeignClient.findCharacters(limit = 2)
                println(characters)
            }

    @Bean
    fun propertySourcePlaceholderConfigurer(): PropertySourcesPlaceholderConfigurer =
            YamlPropertiesFactoryBean().let {
                it.setResources(ClassPathResource("application.yaml"))
                PropertySourcesPlaceholderConfigurer().apply {
                    setProperties(it.`object`!!)
                    setLocation(ClassPathResource("additional.properties"))
                    setIgnoreUnresolvablePlaceholders(true)
                }
            }
}
