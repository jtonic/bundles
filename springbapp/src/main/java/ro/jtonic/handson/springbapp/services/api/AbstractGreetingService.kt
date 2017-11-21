package ro.jtonic.handson.springbapp.services.api

import org.springframework.beans.factory.annotation.Autowired
import ro.jtonic.handson.springbapp.services.impl.GreetingDelegate
import javax.validation.constraints.NotNull

abstract class AbstractGreetingService {

  @Autowired protected lateinit var greetingDelegate: GreetingDelegate

  abstract fun greeting(@NotNull(message = "should not be null") name: String?): String
}