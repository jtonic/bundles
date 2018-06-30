package ro.jtonic.handson.java.designpatterns;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;
import org.junit.Test;

/**
 * Created by Antonel Ernest Pazargic on 30/06/2018.
 *
 * @author Antonel Ernest Pazargic
 */
public class MySingletonTest {

  @Test
  public void testSingletonOne() {
    final MySingleton singleton = MySingleton.getSingleton("/config.txt");
    final Map<String, String> config = singleton.getConfiguration();
    assertThat(config.size(), is(2));
    assertThat(singleton.getValue("1"), is("one"));
  }

  @Test
  public void testInnerStaticClassBaseSingleton() {
    final int poolSize = MySingleton2.getInstance().getPoolSize();
    assertThat(poolSize, is(10));
  }
}
