package com.github.mihowjingle.cartographer.ui.model.level

import com.github.mihowjingle.cartographer.delegate.FxDoublePropertyDelegate
import com.github.mihowjingle.cartographer.model.level.Size
import javafx.beans.property.SimpleStringProperty

/**
 * UI version of [Size]
 */
class ObservableSize(x: Double? = null, z: Double? = null, y: Double? = null) {

    val xProperty = SimpleStringProperty(x?.toString())
    var x: Double? by FxDoublePropertyDelegate(xProperty)

    val zProperty = SimpleStringProperty(z?.toString())
    var z: Double? by FxDoublePropertyDelegate(zProperty)

    val yProperty = SimpleStringProperty(y?.toString())
    var y: Double? by FxDoublePropertyDelegate(yProperty)

    override fun toString(): String {
        return "ObservableSize(x=$x, z=$z, y=$y)"
    }

    val valid: Boolean get() {
        val x = x ?: return false
        val z = z ?: return false
        val y = y ?: return false
        return x > 0.0 && z > 0.0 && y > 0.0 // todo make configurable? size of 0.1, 0.00001, 0.01 is not very good either
    }

    fun toPersistent(): Size {
        val x = x ?: error("Size: x should not be null at this point!")
        val z = z ?: error("Size: z should not be null at this point!")
        val y = y ?: error("Size: y should not be null at this point!")
        return Size(x, z, y)
    }
}