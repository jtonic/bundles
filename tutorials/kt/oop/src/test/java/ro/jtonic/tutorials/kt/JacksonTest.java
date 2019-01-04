package ro.jtonic.tutorials.kt;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by Antonel Ernest Pazargic on 2018-11-30.
 *
 * @author Antonel Ernest Pazargic
 */
public class JacksonTest {

  @JsonFilter(Data.FILTER)
  public static class Data {
    public static final String FILTER = "dataFilter";
    public String data1;
    public String data2;

    public Data() {
    }

    public Data(String data1, String data2) {
      this.data1 = data1;
      this.data2 = data2;
    }

    @Override
    public String toString() {
      final StringBuilder sb = new StringBuilder("Data{");
      sb.append("data1='").append(data1).append('\'');
      sb.append(", data2='").append(data2).append('\'');
      sb.append('}');
      return sb.toString();
    }
  }

  @Test
  public void onlySomeFieldsIncluded() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    SimpleFilterProvider filterProvider = new SimpleFilterProvider().addFilter(Data.FILTER,
        SimpleBeanPropertyFilter.filterOutAllExcept("data1"));
    mapper.setFilterProvider(filterProvider);

    final String json = mapper.writeValueAsString(new Data("data1", "data2"));
    System.out.println("json = " + json);

    final String jsonInit = "{\"data1\":\"data1\",\"data2\":\"data2\"}";
    final Data data = mapper.readValue(jsonInit, Data.class);
    System.out.println("data = " + data);
  }
}
