package ro.jtonic.handson.springbapp.resource

import io.kotlintest.matchers.shouldBe
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by Antonel Ernest Pazargic on 26/10/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GreetingResourceTest {

  @Autowired
  private lateinit var restTemplate: TestRestTemplate

  @LocalServerPort
  private var port: Int = 0

  @Test
  fun greeting() {
    val name = "Antonel"
    val response = restTemplate.getForEntity("http://localhost:$port/greeting/$name", String::class.java)
    response.body shouldBe "Hello $name"
  }
}
