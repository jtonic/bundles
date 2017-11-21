package ro.jtonic.handson.springbapp.services.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import ro.jtonic.handson.springbapp.services.api.AbstractGreetingService
import ro.jtonic.handson.springbapp.services.api.PostProcessor
import javax.validation.constraints.NotNull

@Component
class GreetingService : AbstractGreetingService() {

  @Autowired
  private lateinit var _postProcessor: PostProcessor

  override val postProcessor: PostProcessor
    get() = _postProcessor
}

@Component
class GreetingPostProcessor : PostProcessor {

  override fun postProcess(name: String?): String =
    "Greeting Mr. $name"
}