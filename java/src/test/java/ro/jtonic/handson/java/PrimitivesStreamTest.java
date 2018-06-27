package ro.jtonic.handson.java;

import java.util.IntSummaryStatistics;
import org.junit.Test;

/**
 * Created by Antonel Ernest Pazargic on 25/06/2018.
 *
 * @author Antonel Ernest Pazargic
 */
public class PrimitivesStreamTest {


  @Test
  public void testLongStream() {

    final IntSummaryStatistics statistics = SampleData.albums.findFirst().get().getTracks().mapToInt(value -> value.getLength()).summaryStatistics();
    final int max = statistics.getMax();
    final int min = statistics.getMin();
    final double average = statistics.getAverage();

    System.out.println("min = " + min);
    System.out.println("max = " + max);
    System.out.println("average = " + average);
  }
}
