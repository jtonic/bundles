package ro.jtonic.springboot.restful.configuration;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import ro.jtonic.springboot.restful.converter.StringToPersonConverter;
import ro.jtonic.springboot.restful.model.Person;

/**
 * Created by Antonel Ernest Pazargic on 06/07/2018.
 *
 * @author Antonel Ernest Pazargic
 */
@Configuration
public class ConversionConfig {

  @Bean
  @SuppressWarnings("unchecked")
  ConversionService conversionService() {
    final ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
    factoryBean.setConverters(Sets.newHashSet(stringToPersonConverter()));
    factoryBean.afterPropertiesSet();
    return factoryBean.getObject();
  }

  @Bean
  Converter<String, Person> stringToPersonConverter() {
    return new StringToPersonConverter();
  }
}
