package ro.jtonic.handson.springbapp.resource

import io.kotlintest.matchers.shouldBe
import io.restassured.RestAssured
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.context.embedded.LocalServerPort
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.HttpStatus.OK
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by Antonel Ernest Pazargic on 26/10/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class GreetingResourceTest {

  @LocalServerPort
  private var port: Int = 0

  @Test
  fun `greeting with valid input`() {
    val name = "Antonel"
    val url = "http://localhost:$port/greeting"

    RestAssured.given()
      .queryParam("name", name)
      .`when`()
      .get(url)
      .then()
      .statusCode(OK.value())
      .extract().body().asString() shouldBe "Greeting Mr. $name"
  }

  @Test
  fun `greeting with invalid input`() {
    val url = "http://localhost:$port/greeting"

    val body = RestAssured.given()
      .`when`()
      .get(url)
      .then()
      .statusCode(INTERNAL_SERVER_ERROR.value())
      .extract().body().asString()
    println("body = $body")
  }
}
