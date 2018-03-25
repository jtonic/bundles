package ro.jtonic.handson.springbapp.client.hr

import org.springframework.context.annotation.Bean
import ro.jtonic.handson.springbapp.client.FeignConfiguration

@FeignConfiguration
class HrFeignClientConfig {

    @Bean
    fun errorDecoder() = BusinessErrorDecoder()
}

