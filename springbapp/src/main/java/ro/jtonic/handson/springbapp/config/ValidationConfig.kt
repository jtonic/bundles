package ro.jtonic.handson.springbapp.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor

@Configuration
class ValidationConfig {

  @Bean
  fun methodValidationPostProcessor()  =
    MethodValidationPostProcessor().apply {
      setValidator(localValidatorFactoryBean())
      isProxyTargetClass = true
      setBeforeExistingAdvisors(true)
    }

  @Bean
  fun localValidatorFactoryBean() = LocalValidatorFactoryBean()
}
