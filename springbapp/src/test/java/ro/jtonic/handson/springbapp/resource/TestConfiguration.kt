package ro.jtonic.handson.springbapp.resource

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Bean

/**
 * Created by Antonel Ernest Pazargic on 26/10/2017.
 * @author Antonel Ernest Pazargic
 */
@TestConfiguration
class TestConfiguration {

    @Bean
    fun restTemplate() = TestRestTemplate()
}
