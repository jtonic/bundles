package ro.jtonic.tutorials.kt.fuel

import awaitObjectResult
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.jackson.jacksonDeserializerOf
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import java.util.concurrent.TimeUnit

/**
 * Created by Antonel Ernest Pazargic on 2018-09-27.
 * @author Antonel Ernest Pazargic
 */
class FuelTest {

    data class HttpBinUserAgentModel(var userAgent: String = "")

    data class BodyResponse(var origin: String = "", var url: String = "")

    @Test
    fun `simple fuel test 1`() {
        FuelManager.instance.basePath = "https://httpbin.org"
        "/get".httpGet().responseString { _, _, result ->
            //make a GET to https://httpbin.org/get and do something with response
            result.fold({

            })
            {

            }
        }
        TimeUnit.SECONDS.sleep(10)
    }

    @Test
    fun `simple fuel test 2`() {
        FuelManager.instance.basePath = "https://httpbin.org"
        val (request, response, result) = "/get".httpGet().response()

        println(request.cUrlString())
        println(response)

        result.fold({
            println(it)
        }) {
            kotlin.error(it.errorData)
        }
    }

    @Test
    fun `simple fuel test 3`() {
        runBlocking {
            FuelManager().run {
                basePath = "https://httpbin.org"

                request(Method.GET, "/ip").awaitObjectResult(jacksonDeserializerOf<BodyResponse>())
                        .fold({ data ->
                            println("User agent: ${data.origin}")
                        }, { error ->
                            println("An error of type ${error.exception} happened: ${error.message}")
                        })
            }
        }
    }
}
