package ro.jtonic.handson.springbapp.clientserver.client.hr

import org.springframework.context.annotation.Bean
import ro.jtonic.handson.springbapp.clientserver.client.FeignConfiguration

@FeignConfiguration
class HrFeignClientConfig {

    @Bean
    fun errorDecoder() = BusinessErrorDecoder()
}

