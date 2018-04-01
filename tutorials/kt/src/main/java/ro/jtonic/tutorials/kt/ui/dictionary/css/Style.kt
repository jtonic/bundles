package ro.jtonic.tutorials.kt.ui.dictionary.css

import javafx.scene.paint.Color
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
        val statusBarFace by cssclass()
    }

    init {
        val buttonColor = c("#3460a9")

        appSizeRule {
            minHeight = 600.px
            maxWidth = 800.px
        }
        wrapper {
            padding = box(20.px)
            spacing = 10.px
        }
        buttonFaceColor {
            backgroundColor += buttonColor
            textFill = c("white")
        }
        statusBarFace {
            val buttonColor = c("#7db9cc")
            backgroundColor += buttonColor
            textFill = c("white")
            padding = box(3.px)
            borderColor += box(
                    top = Color.DARKBLUE,
                    right = Color.DARKBLUE,
                    left = Color.DARKBLUE,
                    bottom = Color.DARKBLUE
            )
        }
        viewBgColor {
            val color = c("#49b8fc")
            backgroundColor += color
        }

        importStylesheet("/css/main.css")
    }
}
