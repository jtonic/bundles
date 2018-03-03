package ro.jtonic.handson.springbapp.client.dictionary

import io.kotlintest.matchers.shouldNotBe
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.netflix.feign.FeignContext
import org.springframework.test.context.junit4.SpringRunner
import ro.jtonic.handson.springbapp.config.FeignConfig

/**
 * Created by Antonel Ernest Pazargic on 03/03/2018.
 * @author Antonel Ernest Pazargic
 */
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = [FeignConfig::class])
class DictionaryFeignClientTest {

    @Autowired
    private lateinit var feignContext: FeignContext

    @Autowired
    private lateinit var dictionaryFeignClient: DictionaryFeignClient

    @Test
    fun `test feign client one`() {
        feignContext shouldNotBe null
        dictionaryFeignClient shouldNotBe null
        val translation = dictionaryFeignClient.findWord("deaf")
        translation shouldNotBe null
    }
}
