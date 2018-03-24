package ro.jtonic.handson.springbapp.resource

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ro.jtonic.handson.springbapp.model.hr.Employee

/**
 * Created by Antonel Ernest Pazargic on 23/03/2018.
 * @author Antonel Ernest Pazargic
 */
@RestController
@RequestMapping("hr")
class HrResource {

    @Autowired
    private lateinit var env: Environment

    @GetMapping("employees")
    fun employee(): List<Employee> {
        val port = env.getProperty("local.server.port")
        return listOf(Employee(1, "[$port] Antonel Pazargic"), Employee(2, "[$port] Irina Stan"))
    }
}