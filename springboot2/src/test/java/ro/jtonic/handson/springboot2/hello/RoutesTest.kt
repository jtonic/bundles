package ro.jtonic.handson.springboot2.hello

import io.kotlintest.shouldNotBe
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import ro.jtonic.handson.springboot2.SpringBoot2App

/**
 * Created by Antonel Ernest Pazargic on 2018-11-17.
 * @author Antonel Ernest Pazargic
 */

@RunWith(SpringRunner::class)
@SpringBootTest(classes = [SpringBoot2App::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoutesTest {

    @Autowired
    private lateinit var client: WebTestClient

    @Before
    fun setUp() {
        client shouldNotBe null
    }

    @Test
    fun testHello() {
        client.get()
                .uri("/events/hello1")
                .header("Content-Type", "application/json")
                .exchange()
                .expectStatus().isOk
                .expectBody<String>()
                .isEqualTo("From Tony with love")
    }
}
