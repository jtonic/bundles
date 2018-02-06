package ro.jtonic.tutorials.kt.ui.dictionary.css

import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 05/02/2018.
 * @author Antonel Ernest Pazargic
 */
class Style : Stylesheet() {

    companion object {
        val appSizeRule by cssclass()
        val wrapper by cssclass()
        val buttonFaceColor by cssclass()
        val viewBgColor by cssclass()
    }

    init {
        appSizeRule {
            minHeight = 300.px
            maxWidth = 600.px
        }
        wrapper {
            padding = box(20.px)
            spacing = 10.px
        }
        buttonFaceColor {
            val buttonColor = c("#3460a9")
            backgroundColor += buttonColor
            textFill = c("white")
        }
        viewBgColor {
            val color = c("#49b8fc")
            backgroundColor += color
        }
    }
}