package ro.jtonic.handson.springbapp.client

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.stereotype.Component

/**
 * Created by Antonel Ernest Pazargic on 27/02/2018.
 * @author Antonel Ernest Pazargic
 */
@Component
class DictionaryFeignInterceptor : RequestInterceptor {

    override fun apply(template: RequestTemplate?) {
        template?.run {
            header("app_id", "95aa7f87")
            header("app_key", "f4537d70a1677e67eea48ba76d070fc0")
            header("Content-Type", "application/json")
        }
    }
}