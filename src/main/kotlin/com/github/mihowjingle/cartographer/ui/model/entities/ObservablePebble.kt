package com.github.mihowjingle.cartographer.ui.model.entities

import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType
import com.github.mihowjingle.cartographer.model.entities.Pebble
import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import javafx.beans.property.SimpleStringProperty

/**
 * UI version of [Pebble]
 */
class ObservablePebble(type: PebbleType?, val position: ObservablePosition = ObservablePosition()) {

    var type: PebbleType? = type
        get() {
            return PebbleType.values().find { it.label == typeProperty.value }
        }
        set(value) {
            typeProperty.value = value?.label
            field = value
        }

    // for tableview columns only
    val typeProperty = SimpleStringProperty(type?.label) // cellFormat makes column border disappear :/, so... SimpleStringProperty not SimpleObjectProperty
    val xProperty by position::xProperty
    val zProperty by position::zProperty
    val yProperty by position::yProperty

    fun toPersistent(): Pebble {
        val x = position.x?.toDouble() ?: error("Position: x should not be null at this point!")
        val z = position.z?.toDouble() ?: error("Position: z should not be null at this point!")
        val y = position.y?.toDouble() ?: error("Position: y should not be null at this point!")
        val type = type ?: error("Pebble type should not be null at this point!")
        return Pebble(type, Position(x, z, y))
    }
}