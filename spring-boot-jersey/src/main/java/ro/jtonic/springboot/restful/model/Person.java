package ro.jtonic.springboot.restful.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by Antonel Ernest Pazargic on 06/07/2018.
 *
 * @author Antonel Ernest Pazargic
 */
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

  @JsonProperty("id")
  private Long ssn;

  @JsonProperty("full_name")
  private String name;
}
