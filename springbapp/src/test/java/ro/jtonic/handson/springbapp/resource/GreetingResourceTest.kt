package ro.jtonic.handson.springbapp.resource

import io.kotlintest.matchers.shouldBe
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension

/**
 * Created by Antonel Ernest Pazargic on 26/10/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingResourceTest {

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @LocalServerPort
    private var port: Int = 0

    @ParameterizedTest
    @ValueSource(strings = arrayOf("Hello", "World"))
    fun greeting() {
        val name = "Antonel"
        val response = restTemplate.getForEntity("http://localhost:$port/greeting/$name", String::class.java)
        response.body shouldBe "Hello $name"
    }
}
