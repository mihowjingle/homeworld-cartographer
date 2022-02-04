package com.github.mihowjingle.cartographer.ui.model.common

import javafx.beans.property.SimpleDoubleProperty
import tornadofx.getValue
import tornadofx.setValue

/**
 * z = height!
 */
class ObservablePosition(x: Double, z: Double, y: Double) {

    val xProperty = SimpleDoubleProperty(x)
    var x: Double by xProperty

    val zProperty = SimpleDoubleProperty(z)
    var z: Double by zProperty

    val yProperty = SimpleDoubleProperty(y)
    var y: Double by yProperty
}