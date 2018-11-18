package ro.jtonic.handson.springboot2.hello

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

/**
 * Created by Antonel Ernest Pazargic on 2018-11-17.
 * @author Antonel Ernest Pazargic
 */
@Configuration
class Routes (private val userHandler: UserHandler){

    @Bean
    fun usersRoute() =
            router {
                (accept(MediaType.TEXT_PLAIN)).nest {
                    GET("/hello", userHandler::hello)
                }
            }
}
