package ro.jtonic.handson.java;

import org.junit.Test;

/**
 * Created by Antonel Ernest Pazargic on 06/06/2018.
 *
 * @author Antonel Ernest Pazargic
 */
public class LambdaExpressionTest {

  @Test
  public void simpleEffectiveFinal() {

    final String msg;
    msg = "Tony";
    // msg = "Irina"; // uncomment and an compilation error will occur here
    doWithMsg(() -> System.out.println("msg = " + msg));
  }

  private void doWithMsg(Runnable block) {
    block.run();
  }
}
