package com.github.mihowjingle.cartographer.function.views

import com.github.mihowjingle.cartographer.ui.views.generic.GenericMessageWindow
import tornadofx.Component

/**
 * Opens a simple window, with only the message, obviously, and a button to simply close and do nothing, no other interactions.
 *
 * Shortcut for [openGenericMessageWindow]
 */
fun Component.openGenericAlert(title: String = "", message: String, buttonLabel: String = "OK") {
    openGenericMessageWindow(title, message, ButtonConfig(buttonLabel) {})
}

/**
 * Opens a simple window with a message (question) and a "Yes" button and a "No" button,
 * with respective actions for each button.
 *
 * Shortcut for [openGenericMessageWindow]
 */
fun Component.openGenericQuestion(title: String = "", message: String, ifYes: () -> Unit, ifNo: () -> Unit) {
    openGenericMessageWindow(title, message, ButtonConfig("Yes", ifYes), ButtonConfig("No", ifNo))
}

data class ButtonConfig(val label: String, val action: () -> Unit)

/**
 * Opens a simple window with a message and any number of buttons with actions attached to them.
 */
fun Component.openGenericMessageWindow(title: String = "", message: String, vararg buttons: ButtonConfig) {
    find<GenericMessageWindow>(mapOf(
        GenericMessageWindow::m to message,
        GenericMessageWindow::t to title,
        GenericMessageWindow::buttons to listOf(*buttons),
    )).openModal()
}