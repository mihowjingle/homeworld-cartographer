package com.github.mihowjingle.cartographer.ui.model.entities

import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType
import com.github.mihowjingle.cartographer.model.entities.Pebble
import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

/**
 * UI version of [Pebble]
 */
class ObservablePebble(type: String?, val position: ObservablePosition = ObservablePosition()) {

    val typeProperty = SimpleStringProperty(type)
    var type: String? by typeProperty

    // for tableview columns only
    val xProperty by position::xProperty
    val zProperty by position::zProperty
    val yProperty by position::yProperty

    fun toPersistent(): Pebble {
        val x = position.x?.toDouble() ?: error("Position: x should not be null at this point!")
        val z = position.z?.toDouble() ?: error("Position: z should not be null at this point!")
        val y = position.y?.toDouble() ?: error("Position: y should not be null at this point!")
        return Pebble(PebbleType.values().single { it.label == type }, Position(x, z, y))
    }
}