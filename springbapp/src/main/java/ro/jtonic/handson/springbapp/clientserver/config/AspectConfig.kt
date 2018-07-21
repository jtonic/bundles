package ro.jtonic.handson.springbapp.clientserver.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.EnableAspectJAutoProxy

/**
 * Created by Antonel Ernest Pazargic on 29/05/2018.
 * @author Antonel Ernest Pazargic
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Configuration
class AspectConfig
