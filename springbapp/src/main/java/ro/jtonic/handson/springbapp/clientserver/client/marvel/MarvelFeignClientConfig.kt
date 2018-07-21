package ro.jtonic.handson.springbapp.clientserver.client.marvel

import feign.RequestInterceptor
import org.springframework.context.annotation.Bean
import ro.jtonic.handson.springbapp.clientserver.client.FeignClientConfig

class MarvelFeignClientConfig : FeignClientConfig() {

    @Bean
    fun dictionaryFeignClientInterceptor(): RequestInterceptor {
        return MarvelFeignInterceptor()
    }
}
