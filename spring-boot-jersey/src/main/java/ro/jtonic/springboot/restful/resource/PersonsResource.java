package ro.jtonic.springboot.restful.resource;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;
import ro.jtonic.springboot.restful.model.Person;
import ro.jtonic.springboot.restful.service.PersonsService;

/**
 * Created by Antonel Ernest Pazargic on 08/07/2018.
 *
 * @author Antonel Ernest Pazargic
 */
@Component
@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonsResource {

  private final PersonsService personService;

  public PersonsResource(PersonsService personService) {
    this.personService = personService;
  }

  @GET
  @Path("/{personId}")
  public Person get(@PathParam("personId") Long id) {
    return personService.getById(id);
  }

  @GET
  public List<Person> getAll() {
    return personService.getAll();
  }
}
