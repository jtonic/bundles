package ro.jtonic.tutorials.kt.issues

import io.kotlintest.shouldThrow
import org.junit.Test

class Session {

    companion object INSTANCE {

        private lateinit var session: Session

        fun createSession() = Session().apply {
            session = this
        }

        fun weird() {
            INSTANCE::session.isAbstract // this works
            INSTANCE::session.isInitialized // java.lang.NoSuchFieldError: session ???!!!
        }
    }
}

class SessionTest {

    @Test
    fun `reproduce the issue KT-21862`() {
        Session.createSession()
        shouldThrow<NoSuchFieldError> {
            Session.weird()
        }
    }
}
