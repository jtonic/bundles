package ro.jtonic.handson.springbapp.resource

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Antonel Ernest Pazargic on 26/10/2017.
 * @author Antonel Ernest Pazargic
 */
@RestController
@RequestMapping(path = arrayOf("/greeting"))
class GreetingResource {

    @GetMapping(path = arrayOf("/{person}"))
    fun greeting(@PathVariable("person") person: String) =  "Hello $person"
}