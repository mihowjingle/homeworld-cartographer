package com.github.mihowjingle.cartographer.delegate

import javafx.beans.property.SimpleStringProperty
import kotlin.reflect.KProperty

class FxDoublePropertyDelegate<T>(private val fxProperty: SimpleStringProperty) {
    operator fun getValue(thisRef: T, property: KProperty<*>): Double? {
        return fxProperty.value?.toDoubleOrNull()
    }
    operator fun setValue(thisRef: T, property: KProperty<*>, value: Double?) {
        fxProperty.value = value?.toString()
    }
}