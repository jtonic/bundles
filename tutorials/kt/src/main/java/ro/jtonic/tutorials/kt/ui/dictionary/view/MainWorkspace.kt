package ro.jtonic.tutorials.kt.ui.dictionary.view

import tornadofx.*

/**
 * Created by Antonel Ernest Pazargic on 01/04/2018.
 * @author Antonel Ernest Pazargic
 */
class MainWorkspace : Workspace() {

    private val wordsView: WordsView by inject()

    init {
        add<MainMenu>()
        dock(wordsView)
    }

    override fun onDock() {
        button("Add customer").action {
            log.info("Add customer...")
        }
    }
}
