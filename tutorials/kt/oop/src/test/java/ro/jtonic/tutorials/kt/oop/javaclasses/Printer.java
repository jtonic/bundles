package ro.jtonic.tutorials.kt.oop.javaclasses;

import javax.annotation.Nullable;

/**
 * Created by Antonel Ernest Pazargic on 28/11/2017.
 *
 * @author Antonel Ernest Pazargic
 */
@Nullable
public class Printer {

    public String printPage(String page) {
        if (null == page) {
            return null;
        }
        System.out.printf("Printing page '%s'%n", page);
        return String.format("[printed] %s", page);
    }

    public String printDocument(String document) {
        System.out.printf("Printing document '%s%n'", document);
        return String.format("[printed] %s", document);
    }
}
