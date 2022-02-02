package com.github.mihowjingle.cartographer.ui.model.level

import javafx.beans.property.SimpleDoubleProperty
import tornadofx.getValue
import tornadofx.setValue

/**
 * The numbers are like radius rather than diameter, for example z of 60000 means 120000 total height.
 * 60km above and 60km below the sensor manager plane.
 *
 * x values change between 90 <-> 270 markers
 * y values change between 0 <-> 180 markers
 *
 * so
 *
 * x = 0 line goes between 0 <-> 180 markers
 * y = 0 line goes between 90 <-> 270 markers
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
}