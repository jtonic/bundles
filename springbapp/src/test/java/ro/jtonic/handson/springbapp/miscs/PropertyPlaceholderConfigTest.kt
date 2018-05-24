package ro.jtonic.handson.springbapp.miscs

import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.shouldNotBe
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.env.Environment
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by Antonel Ernest Pazargic on 24/05/2018.
 * @author Antonel Ernest Pazargic
 */
@RunWith(SpringJUnit4ClassRunner::class)
@SpringBootTest
class PropertyPlaceholderConfigTest {

    @Value("\${ro.jtonic.missingProperty}")
    private lateinit var missingProperty: String

    @Value("\${ro.jtonic.missingProperty:}")
    private lateinit var defaultMissingProperty: String

    @Value("\${server.port}")
    private lateinit var serverPort: String

    @Value("\${ro.jtonic.age}")
    private lateinit var jtonicAge: String

    @Autowired
    private lateinit var env: Environment

    @Before
    fun setUp() {
        //        throw RuntimeException("Should not reach this point")
    }

    @Test
    fun `property is not resolved by spring propertyplaceholderconfigurer`() {
        jtonicAge shouldNotBe null
        jtonicAge shouldBe "48"

        missingProperty.run {
            shouldBe("\${ro.jtonic.missingProperty}")
        }

        defaultMissingProperty shouldBe ""

        //todo talk with community why the yaml based properties are not resolved in tests
//        serverPort shouldBe 8080
    }
}
