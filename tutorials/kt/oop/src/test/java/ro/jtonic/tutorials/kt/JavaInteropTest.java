package ro.jtonic.tutorials.kt;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Antonel Ernest Pazargic on 05/02/2018.
 *
 * @author Antonel Ernest Pazargic
 */
public class JavaInteropTest {

  @Test
  public void testInterop() {
    JavaInterop interop = new JavaInterop();
    final String msg = "this is it";
    Assert.assertThat(interop.print(msg, true), CoreMatchers.startsWith("[color]"));
    Assert.assertThat(interop.print(msg), CoreMatchers.startsWith("[gray]"));
  }
}
