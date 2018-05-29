package ro.jtonic.handson.springbapp.aspects

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import ro.jtonic.handson.springbapp.annotation.Audit

/**
 * Created by Antonel Ernest Pazargic on 29/05/2018.
 * @author Antonel Ernest Pazargic
 */
@Aspect
@Component
class FeignClientAspect {

    @Pointcut("execution(* ro.jtonic.handson.springbapp.client..*FeignClient.*(..))")
    fun feignClient() {
    }

    @Pointcut("@target(audit)")
    fun auditable(audit: Audit) {
    }

    @Around("feignClient() && auditable(audit)")
    fun arround(jp: ProceedingJoinPoint, audit: Audit) {
        jp.proceed(jp.args)
    }
}
