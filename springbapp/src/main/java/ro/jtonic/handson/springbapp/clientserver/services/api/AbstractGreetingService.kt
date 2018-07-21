package ro.jtonic.handson.springbapp.clientserver.services.api

import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotNull

abstract class AbstractGreetingService {

  protected abstract val postProcessor: PostProcessor

  fun greeting(name: String?): String {
    println("printing = $name")
    return postProcessor.postProcess(name)
  }
}

@Validated
interface PostProcessor {

  @Validated
  fun postProcess(@NotNull name: String?): String
}
