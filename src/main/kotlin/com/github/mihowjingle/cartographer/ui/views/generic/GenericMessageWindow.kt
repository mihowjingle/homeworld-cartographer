package com.github.mihowjingle.cartographer.ui.views.generic

import com.github.mihowjingle.cartographer.function.views.ButtonConfig
import javafx.geometry.Pos
import javafx.scene.layout.*
import javafx.scene.paint.Paint
import javafx.stage.StageStyle
import tornadofx.*

// yes, there's built-in stuff but... too different in style,
// and I don't have the time/skill with fx, yet, to make the rest of the app similar,
// aaaaand I actually like this simple style more anyway
class GenericMessageWindow : Fragment() {

    val t: String by param()
    val m: String by param()
    val buttons: List<ButtonConfig> by param()

    override fun onBeforeShow() {
        title = t
        val stage = currentStage ?: throw IllegalStateException("Hmm... currentStage is null! Report a bug please, thx.")
        stage.isResizable = false
        stage.initStyle(StageStyle.UNDECORATED)
    }

    override val root = vbox {
        border = Border(BorderStroke(Paint.valueOf("aaaaaa"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths(1.0)))
        vbox {
            minWidth = 400.0
            maxWidth = 400.0
            alignment = Pos.CENTER
            paddingAll = 10
            label(m)
        }
        hbox {
            minHeight = 50.0
            maxHeight = 50.0
            minWidth = 400.0
            maxWidth = 400.0
            alignment = Pos.CENTER
            spacing = 8.0
            for (b in buttons) {
                button(b.label) {
                    action {
                        b.action()
                        close()
                    }
                }
            }
        }
    }
}