package ro.jtonic.handson.springbapp.clientserver.client.hr

import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import ro.jtonic.handson.springbapp.clientserver.annotation.Audit
import ro.jtonic.handson.springbapp.clientserver.model.hr.Employee

/**
 * Created by Antonel Ernest Pazargic on 23/03/2018.
 * @author Antonel Ernest Pazargic
 */
@FeignClient("http://hr", path = "hr", configuration = [HrFeignClientConfig::class])
interface HrFeignClient {

    @GetMapping("employees")
    @Audit
    fun getEmployees(@RequestParam("status_code") statusCode: Int?): List<Employee>
}
