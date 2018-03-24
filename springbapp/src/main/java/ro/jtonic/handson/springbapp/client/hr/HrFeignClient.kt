package ro.jtonic.handson.springbapp.client.hr

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import ro.jtonic.handson.springbapp.model.hr.Employee

/**
 * Created by Antonel Ernest Pazargic on 23/03/2018.
 * @author Antonel Ernest Pazargic
 */
@FeignClient("http://hr", path = "hr", configuration = [HrFeignClientConfig::class])
interface HrFeignClient {

    @GetMapping("employees")
    fun getEmployees(): List<Employee>
}
