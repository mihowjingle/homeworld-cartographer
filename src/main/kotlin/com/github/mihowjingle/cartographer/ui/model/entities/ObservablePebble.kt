package com.github.mihowjingle.cartographer.ui.model.entities

import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType
import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty

class ObservablePebble(type: PebbleType, val position: ObservablePosition = ObservablePosition(0.0, 0.0, 0.0)) {

    val typeProperty = SimpleObjectProperty(type)
    var type: PebbleType
        get() {
            return typeProperty.value
        }
        set(value) {
            typeProperty.value = value
            labelProperty.value = value.label
        }

    val labelProperty = SimpleStringProperty(type.label) // needed because cellFormat makes column border disappear...

    val xProperty by position::xProperty
    val zProperty by position::zProperty
    val yProperty by position::yProperty
}