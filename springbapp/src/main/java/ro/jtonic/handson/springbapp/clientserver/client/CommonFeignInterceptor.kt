package ro.jtonic.handson.springbapp.clientserver.client

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.stereotype.Component

/**
 * Created by Antonel Ernest Pazargic on 27/02/2018.
 * @author Antonel Ernest Pazargic
 */
@Component
class CommonFeignInterceptor : RequestInterceptor {

    override fun apply(template: RequestTemplate?) {
        println("In common feign interceptor.")
    }
}
