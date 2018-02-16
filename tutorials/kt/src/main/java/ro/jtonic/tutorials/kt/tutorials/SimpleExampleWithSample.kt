package ro.jtonic.tutorials.kt.tutorials

/**
 * Created by Antonel Ernest Pazargic on 14/02/2018.
 * @author Antonel Ernest Pazargic
 */
class SimpleExampleWithSample {

    /**
     *
     * @sample [ro.jtonic.tutorials.kt.tutorials.SimpleExampleWithSampleTest.testFoo1]
     * @sample [ro.jtonic.tutorials.kt.tutorials.SimpleExampleWithSampleTest.testFoo2]
     *
     * @param param - req param
     * @return modified param as new string
     * @since 0.0.5
     */
    fun foo(param: String) = "return $param"
}