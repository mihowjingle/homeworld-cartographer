package com.github.mihowjingle.cartographer.ui.model.common

import com.github.mihowjingle.cartographer.delegate.FxDoublePropertyDelegate
import com.github.mihowjingle.cartographer.model.common.Position
import javafx.beans.property.SimpleStringProperty

/**
 * UI version of [Position]
 */
class ObservablePosition(x: Double? = null, z: Double? = null, y: Double? = null) {

    constructor(other: ObservablePosition) : this(other.x, other.z, other.y)

    val xProperty = SimpleStringProperty(x?.toString())
    var x: Double? by FxDoublePropertyDelegate(xProperty)

    val zProperty = SimpleStringProperty(z?.toString())
    var z: Double? by FxDoublePropertyDelegate(zProperty)

    val yProperty = SimpleStringProperty(y?.toString())
    var y: Double? by FxDoublePropertyDelegate(yProperty)

    val valid: Boolean get() = x != null && z != null && y != null

    fun toPersistent(): Position {
        val x = x ?: error("Position: x should not be null at this point!")
        val z = z ?: error("Position: z should not be null at this point!")
        val y = y ?: error("Position: y should not be null at this point!")
        return Position(x, z, y)
    }

    infix fun copyInto(other: ObservablePosition) {
        other.x = this.x
        other.z = this.z
        other.y = this.y
    }
}