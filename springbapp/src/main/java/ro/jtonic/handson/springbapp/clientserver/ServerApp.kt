package ro.jtonic.handson.springbapp.clientserver

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import ro.jtonic.handson.springbapp.clientserver.annotation.Client
import ro.jtonic.handson.springbapp.clientserver.annotation.Server
import ro.jtonic.handson.springbapp.clientserver.client.FeignConfiguration

/**
 * Created by Antonel Ernest Pazargic on 25/10/2017.
 * @author Antonel Ernest Pazargic
 */
@SpringBootApplication
@ComponentScan(excludeFilters = [ComponentScan.Filter(value = [FeignConfiguration::class, Client::class])])
@Server
class ServerApp {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplicationBuilder().web(WebApplicationType.SERVLET).sources(ServerApp::class.java).build(*args).run()
        }
    }

    @Bean
    fun applicationRunner() =
            ApplicationRunner { args ->
                println("".padStart(80, '='))
                println("Application is running....")
                println("Arguments = $args")
                println("".padStart(80, '='))
            }
}
