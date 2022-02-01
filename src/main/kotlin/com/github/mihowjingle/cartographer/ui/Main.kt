package com.github.mihowjingle.cartographer.ui

import com.github.mihowjingle.cartographer.ui.views.MainView
import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch

class HomeworldCartographer : App(MainView::class) {
    override fun start(stage: Stage) {
        with(stage) {
            minWidth = 800.0
            minHeight = 600.0
            super.start(this)
        }
    }
}

fun main() {
    launch<HomeworldCartographer>()
}