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
            val xAxis = Random.nextDouble(360.0)
            val zAxis = Random.nextDouble(360.0)
            val yAxis = Random.nextDouble(360.0)
            return ObservableOrientation(xAxis, zAxis, yAxis)
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

    fun toPersistent(): Orientation {
        val xAxis = xAxis ?: error("Orientation: x axis should not be null at this point!")
        val zAxis = zAxis ?: error("Orientation: z axis should not be null at this point!")
        val yAxis = yAxis ?: error("Orientation: y axis should not be null at this point!")
        return Orientation(xAxis, zAxis, yAxis)
    }
}