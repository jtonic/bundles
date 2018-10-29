package ro.jtonic.coursera.one;

import static ro.jtonic.coursera.one.StringExtentionsKt.lastChar;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Antonel Ernest Pazargic on 29/10/2018.
 *
 * @author Antonel Ernest Pazargic
 */
public class Week2JavaTest {

  @Test
  public void StringExtensionsShouldWork() {
    Assert.assertEquals(lastChar("antonel"), 'l');
  }
}
