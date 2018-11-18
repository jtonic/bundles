package ro.jtonic.handson.springboot2.hello

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by Antonel Ernest Pazargic on 2018-11-18.
 * @author Antonel Ernest Pazargic
 */
@RestController
class UsersResource {

    @GetMapping("/hello1", consumes = [MediaType.APPLICATION_JSON_VALUE],
            produces = [MediaType.TEXT_PLAIN_VALUE])
    fun hello(): String = "From Tony with love"
}
