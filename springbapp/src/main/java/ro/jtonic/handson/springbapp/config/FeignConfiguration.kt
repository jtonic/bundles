package ro.jtonic.handson.springbapp.config

import org.springframework.cloud.netflix.feign.EnableFeignClients
import org.springframework.context.annotation.Configuration
import ro.jtonic.handson.springbapp.client.DictionaryFeignClient

/**
 * Created by Antonel Ernest Pazargic on 26/02/2018.
 * @author Antonel Ernest Pazargic
 */
@Configuration
@EnableFeignClients(basePackageClasses = [DictionaryFeignClient::class])
class FeignConfiguration