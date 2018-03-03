package ro.jtonic.handson.springbapp.client.marvel

import io.kotlintest.matchers.beInstanceOf
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldNotBe
import org.junit.Test

/**
 * Created by Antonel Ernest Pazargic on 03/03/2018.
 *
 * @author Antonel Ernest Pazargic
 */
class MarvelFeignInterceptorTest {

    @Test
    fun `test the digest`() {
        val hash = MarvelFeignInterceptor().computeMd5(ts, PRIVATE_KEY, PUBLIC_KEY)
        hash shouldNotBe null
        hash should beInstanceOf(String::class)
    }
}
