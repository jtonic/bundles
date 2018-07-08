package ro.jtonic.springboot.restful.service;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.stereotype.Service;
import ro.jtonic.springboot.restful.model.Person;

/**
 * Created by Antonel Ernest Pazargic on 08/07/2018.
 *
 * @author Antonel Ernest Pazargic
 */
@Service
public class PersonsService {

  private static final List<Person> persons = Lists.asList(
    Person.builder().ssn(1L).name("Antonel").build(),
    new Person[] {Person.builder().ssn(2L).name("Irina").build()}
  );

  public Person getById(Long id) {
    return Person.builder().ssn(id).name("Antonel").build();
  }

  public List<Person> getAll() {
    return persons;
  }
}
