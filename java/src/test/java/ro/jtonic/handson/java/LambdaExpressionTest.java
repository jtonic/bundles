package ro.jtonic.handson.java;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.function.BinaryOperator;
import org.junit.Test;

/**
 * Created by Antonel Ernest Pazargic on 06/06/2018.
 *
 * @author Antonel Ernest Pazargic
 */
public class LambdaExpressionTest {

  @Test
  public void simpleEffectiveFinal() {

    String msg;
    msg = "Tony";
    // msg = "Irina"; // uncomment and an compilation error will occur in the next line
    doWithMsg(() -> System.out.println("msg = " + msg));
  }

  @Test
  public void testFunctionalInterface() {
    consume("Tony", msg -> System.out.println("msg = " + msg));
  }

  @Test
  public void testBinaryOperator() {
    BinaryOperator<Long> sum = (a, b) -> a + b;
    assertThat(sum.apply(1L, 3L), equalTo(4L));
  }

  @Test
  public void testBinaryOperator2() {
    BinaryOperator<Long> incLeft = (a, b) -> ++a;
    assertThat(incLeft.apply(1L, 3L), equalTo(2L));
  }

  private void doWithMsg(Runnable block) {
    block.run();
  }

  private void consume(String target, MyConsumer consumer) {
    consumer.consume(target);
  }

  @FunctionalInterface
  public interface MyConsumer {

    void consume(String msg);

    // void print(String msg); //uncomment this and get an compilation error stating that MyConsumer is not a functional interface.
  }
}
