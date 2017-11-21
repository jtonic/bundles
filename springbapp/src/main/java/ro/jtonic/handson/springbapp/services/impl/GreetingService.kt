package ro.jtonic.handson.springbapp.services.impl

import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import ro.jtonic.handson.springbapp.services.api.AbstractGreetingService
import javax.validation.constraints.NotNull

@Component
@Validated
class GreetingService : AbstractGreetingService() {

  @Validated
  override fun greeting(@NotNull(message = "should not be null") name: String?) =
    greetingDelegate.greeting(name)
}