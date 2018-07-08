package ro.jtonic.springboot.restful.configuration;

import javax.annotation.PostConstruct;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import ro.jtonic.springboot.restful.resource.PersonsResource;

/**
 * Created by Antonel Ernest Pazargic on 08/07/2018.
 *
 * @author Antonel Ernest Pazargic
 */
@Configuration
public class JerseyConfig extends ResourceConfig {

  @PostConstruct
  void setUp() {
    register(PersonsResource.class);
  }
}
