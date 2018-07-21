package ro.jtonic.handson.springbapp.clientserver.config

import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.Configuration

/**
 * Created by Antonel Ernest Pazargic on 26/02/2018.
 * @author Antonel Ernest Pazargic
 */
@Configuration
@EnableFeignClients(basePackages = ["ro.jtonic.handson.springbapp.client"])
class FeignConfig
