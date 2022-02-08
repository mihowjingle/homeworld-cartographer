package com.github.mihowjingle.cartographer.ui.model.entities

import com.github.mihowjingle.cartographer.delegate.FxDoublePropertyDelegate
import com.github.mihowjingle.cartographer.model.entities.StartingPosition
import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import javafx.beans.property.SimpleStringProperty

/**
 * UI version of [StartingPosition]
 */
class ObservableStartingPosition(var playerIndex: Int, val position: ObservablePosition = ObservablePosition(), zAxisOrientation: Double? = null) {

    val zAxisOrientationProperty = SimpleStringProperty(zAxisOrientation?.toString())
    var zAxisOrientation: Double? by FxDoublePropertyDelegate(zAxisOrientationProperty)

    // for tableview columns only
    val xProperty by position::xProperty
    val zProperty by position::zProperty
    val yProperty by position::yProperty

    init {
        if (playerIndex !in 0..7) {
            throw IllegalArgumentException("Invalid play index $playerIndex! 0..7 allowed.")
        }
    }

    fun toPersistent(): StartingPosition {
        val zAxisOrientation = zAxisOrientation ?: error("zAxisOrientation should not be null at this point!")
        return StartingPosition(playerIndex, position.toPersistent(), zAxisOrientation)
    }

    /**
     * !!! Player index is not copied!
     */
    infix fun copyInto(other: ObservableStartingPosition) {
        this.position copyInto other.position
        other.zAxisOrientation = this.zAxisOrientation
    }

    val valid: Boolean get() = position.valid && zAxisOrientation != null
}