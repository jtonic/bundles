package ro.jtonic.handson.springbapp.clientserver.services.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ro.jtonic.handson.springbapp.clientserver.services.api.AbstractGreetingService
import ro.jtonic.handson.springbapp.clientserver.services.api.PostProcessor

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
