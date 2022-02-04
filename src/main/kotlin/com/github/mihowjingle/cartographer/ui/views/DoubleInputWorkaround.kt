package com.github.mihowjingle.cartographer.ui.views

import javafx.beans.value.ObservableValue
import javafx.event.EventTarget
import javafx.scene.control.TextField
import tornadofx.enableWhen
import tornadofx.filterInput
import tornadofx.isDouble
import tornadofx.textfield
import kotlin.reflect.KMutableProperty0

// todo oof, this stinks, but spinner is broken with Double (unless editable = false, but cmon...)
fun EventTarget.doubleInputWorkaround(prop: KMutableProperty0<Double>, initialValue: String = prop.get().toString(), enabled: ObservableValue<Boolean>? = null, allowNegative: Boolean = false): TextField {
    return textfield(value = initialValue) {
        filterInput {
            it.controlNewText.isDouble()
        }
        setOnKeyReleased {
            if (this.text.isNotBlank()) {
                prop.set(this.text.toDouble())
            }
        }
        if (enabled != null ) {
            enableWhen {
                enabled
            }
        }
    }
}