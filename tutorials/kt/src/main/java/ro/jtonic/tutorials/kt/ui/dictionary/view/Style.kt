package ro.jtonic.tutorials.kt.ui.dictionary.view

import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 05/02/2018.
 * @author Antonel Ernest Pazargic
 */
class Style : Stylesheet() {

    companion object {
        val appSizeRule by cssclass()
    }

    init {
        select(appSizeRule) {
            minHeight = 500.px
            maxWidth = 600.px
        }
    }
}