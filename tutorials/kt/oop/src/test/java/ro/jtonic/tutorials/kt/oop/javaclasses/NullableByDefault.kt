package ro.jtonic.tutorials.kt.oop.javaclasses

import java.lang.annotation.ElementType
import javax.annotation.Nullable
import javax.annotation.meta.TypeQualifierDefault

/**
 * Created by Antonel Ernest Pazargic on 03/12/2017.
 * @author Antonel Ernest Pazargic
 */
@Nullable
@TypeQualifierDefault(ElementType.METHOD)
annotation class NullableByDefault