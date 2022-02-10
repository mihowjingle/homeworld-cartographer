package com.github.mihowjingle.cartographer.ui.views.generic

import javafx.geometry.Pos
import tornadofx.*

// yes, there's built-in stuff but... too different in style,
// and I don't have the time/skill with fx, yet, to make the rest of the app similar,
// aaaaand I actually like this simplistic style more anyway
class GenericAlert : Fragment() {

    val t: String by param()
    val m: String by param()
    val bl: String by param()

    override fun onDock() {
        title = t
        val stage = currentStage ?: throw IllegalStateException("Hmm... currentStage is null! Report a bug please, thx.")
        stage.isResizable = false
    }

    override val root = vbox {
        vbox {
            minWidth = 400.0
            maxWidth = 400.0
            alignment = Pos.CENTER
            paddingAll = 10
            label(m)
        }
        vbox {
            minHeight = 50.0
            maxHeight = 50.0
            minWidth = 400.0
            maxWidth = 400.0
            alignment = Pos.CENTER
            button(bl) {
                action {
                    close()
                }
            }
        }
    }
}