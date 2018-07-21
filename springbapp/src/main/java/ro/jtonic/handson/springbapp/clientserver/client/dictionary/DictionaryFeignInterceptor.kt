package ro.jtonic.handson.springbapp.clientserver.client.dictionary

import feign.RequestInterceptor
import feign.RequestTemplate

class DictionaryFeignInterceptor : RequestInterceptor {

    override fun apply(template: RequestTemplate?) {
        println("in interceptor 1...")
        template?.run {
            header("app_id", "95aa7f87")
            header("app_key", "f4537d70a1677e67eea48ba76d070fc0")
            header("Content-Type", "application/json")
        }
    }
}
