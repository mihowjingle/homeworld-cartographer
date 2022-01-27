package com.github.mihowjingle.cartographer.ui.views

import tornadofx.*

class MainView : View() {

    override val root = vbox {
        style {
            paddingAll = 10
        }
        button("Hello").action {
            println("Well hello there!")
        }
    }
}