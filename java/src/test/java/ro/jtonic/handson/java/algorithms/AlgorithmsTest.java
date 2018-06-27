package ro.jtonic.handson.java.algorithms;

import org.junit.Test;

/**
 * Created by Antonel Ernest Pazargic on 27/06/2018.
 *
 * @author Antonel Ernest Pazargic
 */
public class AlgorithmsTest {

  @Test
  public void testFibonacci_noRecursion() {
    fibNoRecursion(10);
  }

  @Test
  public void testFibonacci_Recursion() {
    for (int i = 0; i <= 10; i++) {
      System.out.printf("i = %d, fib = %d%n", i, fibRecursion(i));
    }
  }

  private void fibNoRecursion(int n) {
    int f = 0;
    int g = 1;

    for (int i = 1; i <= n; i++) {
      System.out.print(f + " ");
      f = f + g;
      g = f - g;
    }
    System.out.println();
  }

  private int fibRecursion(int n) {
    if (n <= 1) {
      return n;
    }
    return fibRecursion(n - 2) + fibRecursion(n - 1);
  }
}
