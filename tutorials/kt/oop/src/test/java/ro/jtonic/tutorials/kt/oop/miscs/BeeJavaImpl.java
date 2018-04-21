package ro.jtonic.tutorials.kt.oop.miscs;

/**
 * Created by Antonel Ernest Pazargic on 21/04/2018.
 *
 * @author Antonel Ernest Pazargic
 */
public class BeeJavaImpl implements BeeJava, BooKotlin {

  public static void main(String[] args) {
    BeeJava beeJava = new BeeJavaImpl();
    System.out.println(beeJava.bee());

    BooKotlin booKotlin = new BeeJavaImpl();
    System.out.println(booKotlin.boo());
  }
}
