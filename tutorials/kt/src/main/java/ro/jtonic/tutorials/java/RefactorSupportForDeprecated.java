package ro.jtonic.tutorials.java;

/**
 * Created by Antonel Ernest Pazargic on 30/11/2017.
 *
 * @author Antonel Ernest Pazargic
 */
public class RefactorSupportForDeprecated {

    public static void main(String[] args) {
        RefactorSupportForDeprecated rsfd = new RefactorSupportForDeprecated();
        // this cool feature of refactor use the suggestion of the deprecated method is cool
        // Idea 2017.3
        rsfd.foo("Antonel");
    }

    private void fee(String name) {
        if (null != name) {
            System.out.println("name = " + name);
        }
    }

    /**
     *
     * @param name
     *
     * use {@link RefactorSupportForDeprecated#fee(String)}
     */
    @Deprecated
    private void foo(String name) {
        System.out.println("name = " + name);
    }

}
