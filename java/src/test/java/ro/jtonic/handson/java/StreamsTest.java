package ro.jtonic.handson.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
                                        .flatMap(numbers -> numbers.stream())
                                        .collect(Collectors.toList());

    Assert.assertEquals(Arrays.asList(1, 2, 3, 4), collected);
  }
}
