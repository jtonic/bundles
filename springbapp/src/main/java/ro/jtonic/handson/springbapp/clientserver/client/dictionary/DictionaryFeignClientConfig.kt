package ro.jtonic.handson.springbapp.clientserver.client.dictionary

import feign.RequestInterceptor
import org.springframework.context.annotation.Bean
import ro.jtonic.handson.springbapp.clientserver.client.FeignClientConfig

class DictionaryFeignClientConfig : FeignClientConfig() {

    @Bean
    fun dictionaryFeignInterceptor(): RequestInterceptor {
        return DictionaryFeignInterceptor()
    }
}
