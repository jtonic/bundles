package ro.jtonic.handson.java.designpatterns;

/**
 * Created by Antonel Ernest Pazargic on 30/06/2018.
 *
 * This is a better implementation because it avoid the java memory model in older jvm versions
 * <br>The CONS:
 * <ul>
 *   </li>It's not possible to pass arguments for singleton creation. In lazy instantiation it is </li>
 * </ul>
 * @author Antonel Ernest Pazargic
 */
public final class MySingleton2 {

  private int poolSize;

  private static class Helper {
    private static final MySingleton2 INSTANCE = new MySingleton2().init();
  }

  private MySingleton2() {
  }

  private MySingleton2 init() {
    poolSize = 10;
    return this;
  }

  public static MySingleton2 getInstance() {
    return Helper.INSTANCE;
  }

  public int getPoolSize() {
    return poolSize;
  }
}
