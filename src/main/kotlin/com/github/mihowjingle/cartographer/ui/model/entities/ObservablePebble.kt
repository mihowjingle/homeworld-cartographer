package com.github.mihowjingle.cartographer.ui.model.entities

import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType
import com.github.mihowjingle.cartographer.model.entities.Pebble
import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import javafx.beans.property.SimpleStringProperty

/**
 * UI version of [Pebble]
 */
class ObservablePebble(type: PebbleType?, val position: ObservablePosition = ObservablePosition()) {

    val typeProperty = SimpleStringProperty(type?.label) // cellFormat makes column border disappear :/, so... SimpleStringProperty not SimpleObjectProperty
    var type: PebbleType?
        get() {
            return PebbleType.values().find { it.label == typeProperty.value }
        }
        set(value) {
            typeProperty.value = value?.label
        }

    // for tableview columns only
    val xProperty by position::xProperty
    val zProperty by position::zProperty
    val yProperty by position::yProperty

    fun toPersistent(): Pebble {
        val type = type ?: error("Pebble type should not be null at this point!")
        return Pebble(type, position.toPersistent())
    }

    infix fun copyInto(other: ObservablePebble) {
        other.type = this.type
        this.position copyInto other.position
    }
}