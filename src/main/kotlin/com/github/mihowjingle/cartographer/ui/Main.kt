package com.github.mihowjingle.cartographer.ui

import com.github.mihowjingle.cartographer.function.level.toLua
import com.github.mihowjingle.cartographer.ui.views.MainView
import com.github.mihowjingle.cartographer.ui.views.testLevel
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
    println(testLevel.toLua())
    launch<HomeworldCartographer>()
}