package ro.jtonic.handson.springbapp.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ro.jtonic.handson.springbapp.services.impl.GreetingService

/**
 * Created by Antonel Ernest Pazargic on 26/10/2017.
 * @author Antonel Ernest Pazargic
 */
@RestController
@RequestMapping(path = arrayOf("/greeting"))
class GreetingResource(@Autowired private val greetingService: GreetingService) {

  @GetMapping
  fun greeting(@RequestParam("name", required = false) person: String?) = greetingService.greeting(person)
}