package ro.jtonic.handson.java;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Antonel Ernest Pazargic on 07/06/2018.
 *
 * @author Antonel Ernest Pazargic
 */
public class StreamsTest {

  @Test
  public void testSimpleStream() {
    final List<Integer> collected = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
                                          .flatMap(Collection::stream)
                                          .collect(toList());
    Assert.assertEquals(Arrays.asList(1, 2, 3, 4), collected);
  }

  @Test
  public void testSimpleMaxFinalOperator() {
    final Optional<String> max = Stream.of("Antonel", "Irina", "Oana", "Ion", "Liviu").max(Comparator.comparing(name -> name.length()));
    assertTrue(max.isPresent());
    assertEquals("Antonel", max.get());
  }
}
