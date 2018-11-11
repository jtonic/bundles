package ro.jtonic.coursera.one

import io.kotlintest.shouldBe

fun main(args: Array<String>) {
    val s1: String? = null
    val s2: String? = ""
    s1.isEmptyOrNull() shouldBe true
    s2.isEmptyOrNull() shouldBe true

    val s3 = "   "
    s3.isEmptyOrNull() shouldBe false
}

fun String?.isEmptyOrNull(): Boolean = when {
    this == null -> true
    this.isEmpty() -> true
    else -> false
}


