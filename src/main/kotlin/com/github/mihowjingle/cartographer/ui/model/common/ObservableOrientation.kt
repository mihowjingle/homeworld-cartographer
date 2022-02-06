package com.github.mihowjingle.cartographer.ui.model.common

import com.github.mihowjingle.cartographer.delegate.FxDoublePropertyDelegate
import com.github.mihowjingle.cartographer.model.common.Orientation
import javafx.beans.property.SimpleStringProperty
import kotlin.random.Random

/**
 * UI version of [Orientation]
 */
class ObservableOrientation(xAxis: Double? = null, zAxis: Double? = null, yAxis: Double? = null) {
    companion object {
        fun random(): ObservableOrientation {
            val x = Random.nextDouble(360.0)
            val z = Random.nextDouble(360.0)
            val y = Random.nextDouble(360.0)
            return ObservableOrientation(x, z, y)
        }
    }

    constructor(other: ObservableOrientation) : this(other.xAxis, other.zAxis, other.yAxis)

    val xAxisProperty = SimpleStringProperty(xAxis?.toString())
    var xAxis: Double? by FxDoublePropertyDelegate(xAxisProperty)

    val zAxisProperty = SimpleStringProperty(zAxis?.toString())
    var zAxis: Double? by FxDoublePropertyDelegate(zAxisProperty)

    val yAxisProperty = SimpleStringProperty(yAxis?.toString())
    var yAxis: Double? by FxDoublePropertyDelegate(yAxisProperty)

    val valid: Boolean get() = xAxis != null && zAxis != null && yAxis != null
}