package ro.jtonic.handson.java;

import java.util.function.BinaryOperator;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
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
    Assert.assertThat(sum.apply(1L, 3L), CoreMatchers.equalTo(4L));
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
