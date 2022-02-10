package com.github.mihowjingle.cartographer.function.views

import com.github.mihowjingle.cartographer.ui.views.generic.GenericAlert
import tornadofx.Component

fun Component.openGenericAlert(title: String = "", message: String, buttonLabel: String = "OK") {
    find<GenericAlert>(mapOf(
        GenericAlert::m to message,
        GenericAlert::t to title,
        GenericAlert::bl to buttonLabel,
    )).openModal()
}