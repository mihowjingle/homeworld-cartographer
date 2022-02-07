package com.github.mihowjingle.cartographer.delegate

import javafx.beans.property.SimpleStringProperty
import kotlin.reflect.KProperty

class FxDoublePropertyDelegate<T>(private val fxProperty: SimpleStringProperty) {
    operator fun getValue(thisRef: T, property: KProperty<*>): Double? {
        return fxProperty.value?.toDoubleOrNull()
    }
    operator fun setValue(thisRef: T, property: KProperty<*>, value: Double?) {
        fxProperty.value = value?.toString() ?: "" // *
    }
}

// * empty string because of a bug in javafx :O
// https://stackoverflow.com/questions/34865132/textformatter-throws-exception-when-binding-bidirectional-to-a-null-string
// https://bugs.openjdk.java.net/browse/JDK-8147827