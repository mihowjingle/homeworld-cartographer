package com.github.mihowjingle.cartographer.ui.model.level

import com.github.mihowjingle.cartographer.model.level.Size
import javafx.beans.property.SimpleDoubleProperty
import tornadofx.getValue
import tornadofx.setValue

/**
 * UI version of [Size]
 */
class ObservableSize(x: Double = 0.0, z: Double = 0.0, y: Double = 0.0) {

    // todo private for now, until spinner is fixed for Double
    //  and i can get rid of the workaround
    //  btw file issue?
    private val xProperty = SimpleDoubleProperty(x)
    var x: Double by xProperty

    private val zProperty = SimpleDoubleProperty(z)
    var z: Double by zProperty

    private val yProperty = SimpleDoubleProperty(y)
    var y: Double by yProperty

    override fun toString(): String {
        return "ObservableSize(x=$x, z=$z, y=$y)"
    }

    fun toPersistent(): Size {
        return Size(x, z, y)
    }
}