package ro.jtonic.handson.springbapp.clientserver.resource

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ro.jtonic.handson.springbapp.clientserver.services.api.AbstractGreetingService

/**
 * Created by Antonel Ernest Pazargic on 26/10/2017.
 * @author Antonel Ernest Pazargic
 */
@RestController
@RequestMapping(path = ["/greeting"])
class GreetingResource(private val greetingService: AbstractGreetingService) {

  @GetMapping
  fun greeting(@RequestParam("name", required = false) person: String?) = greetingService.greeting(person)
}
