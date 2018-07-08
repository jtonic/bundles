package ro.jtonic.springboot.restful.converter;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import org.springframework.core.convert.converter.Converter;
import ro.jtonic.springboot.restful.model.Person;

/**
 * Created by Antonel Ernest Pazargic on 06/07/2018.
 *
 * @author Antonel Ernest Pazargic
 */
public class StringToPersonConverter implements Converter<String, Person> {

  @Override
  public Person convert(String source) {
    final Iterable<String> it = Splitter.on(',').omitEmptyStrings().split(source);
    final String[] elements = Iterables.toArray(it, String.class);

    final long ssn = Long.parseLong(elements[0]);
    final String name = elements[1];
    return Person.builder().ssn(ssn).name(name).build();
  }
}
