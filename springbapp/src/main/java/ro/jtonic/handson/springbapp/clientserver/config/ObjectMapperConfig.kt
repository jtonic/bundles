package ro.jtonic.handson.springbapp.clientserver.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by Antonel Ernest Pazargic on 24/03/2018.
 * @author Antonel Ernest Pazargic
 */
@Configuration
class ObjectMapperConfig {

    @Bean
    fun mapper() = ObjectMapper().registerModule(KotlinModule())!!
}
