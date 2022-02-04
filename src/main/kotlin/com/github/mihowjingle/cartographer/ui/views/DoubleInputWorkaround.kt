package com.github.mihowjingle.cartographer.ui.views

import javafx.beans.value.ObservableValue
import javafx.event.EventTarget
import javafx.scene.control.TextField
import tornadofx.enableWhen
import tornadofx.filterInput
import tornadofx.textfield
import kotlin.reflect.KMutableProperty0

// todo oof, this stinks, but spinner is broken with Double (unless editable = false, but cmon...)
fun EventTarget.doubleInputWorkaround(prop: KMutableProperty0<Double>, initialValue: String = prop.get().toString(), enabled: ObservableValue<Boolean>? = null, allowNegative: Boolean = false): TextField {
    return textfield(value = initialValue) {
        filterInput {
            it.controlNewText.canBecomeDouble(allowNegative)
        }
        setOnKeyReleased {
            if (this.text.isNotBlank() && this.text != "-") {
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

/**
 * Returns true when and only when [this] String is a valid candidate for a Double value.
 * Which is why, for example, "-" results in true (if [allowNegative] is true), because it can still be -1, -0.00089 or whatever,
 * even though "-" is not a valid Double value itself.
 * For the same reason, empty String is also ok - empty string can become any string after some keystrokes. Etc.
 */
fun String.canBecomeDouble(allowNegative: Boolean = false): Boolean {

    if (this == "") {
        return true
    }

    if (allowNegative && this == "-") {
        return true
    }

    if (!allowNegative && startsWith('-')) {
        return false
    }

    return try {
        this.toDouble()
        true
    } catch (_ : Exception) {
        false
    }
}