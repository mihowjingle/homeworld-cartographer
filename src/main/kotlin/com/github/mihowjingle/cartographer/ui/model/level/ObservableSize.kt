package com.github.mihowjingle.cartographer.ui.model.level

import com.github.mihowjingle.cartographer.model.level.Size
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

/**
 * UI version of [Size]
 */
class ObservableSize(x: String? = null, z: String? = null, y: String? = null) {

    val xProperty = SimpleStringProperty(x)
    var x: String? by xProperty

    val zProperty = SimpleStringProperty(z)
    var z: String? by zProperty

    val yProperty = SimpleStringProperty(y)
    var y: String? by yProperty

    override fun toString(): String {
        return "ObservableSize(x=$x, z=$z, y=$y)"
    }

    val valid: Boolean get() {
        val x = x?.toDoubleOrNull() ?: return false
        val z = z?.toDoubleOrNull() ?: return false
        val y = y?.toDoubleOrNull() ?: return false
        return x > 0.0 && z > 0.0 && y > 0.0 // todo make configurable? size of 0.1, 0.00001, 0.01 is not very good either
    }

    fun toPersistent(): Size {
        val x = x?.toDouble() ?: error("Size: x should not be null at this point!")
        val z = z?.toDouble() ?: error("Size: z should not be null at this point!")
        val y = y?.toDouble() ?: error("Size: y should not be null at this point!")
        return Size(x, z, y)
    }
}