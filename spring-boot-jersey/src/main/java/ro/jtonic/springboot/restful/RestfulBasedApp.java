package ro.jtonic.springboot.restful;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;
import ro.jtonic.springboot.restful.model.Person;

@SpringBootApplication
public class RestfulBasedApp {

	private static final Logger LOG = LoggerFactory.getLogger(RestfulBasedApp.class);

	private final ConversionService conversionService;

	public RestfulBasedApp(ConversionService conversionService) {
		this.conversionService = conversionService;
	}

	public static void main(String[] args) {
		SpringApplication.run(RestfulBasedApp.class, args);
	}

	@Bean
	public ApplicationRunner applicationRunner() {
		return (args) -> {
			final Person person = conversionService.convert("1, Antonel", Person.class);
			LOG.info("==================");
			LOG.info("==================");
			LOG.info("Person: {}", person);
			LOG.info("==================");
		};
	}
}
