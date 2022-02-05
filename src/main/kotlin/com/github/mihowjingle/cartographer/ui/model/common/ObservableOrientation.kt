package com.github.mihowjingle.cartographer.ui.model.common

import com.github.mihowjingle.cartographer.function.strings.isDouble
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue
import kotlin.random.Random

class ObservableOrientation(xAxis: String? = null, zAxis: String? = null, yAxis: String? = null) {
    companion object {
        fun random(): ObservableOrientation {
            val x = Random.nextDouble(360.0).toString()
            val z = Random.nextDouble(360.0).toString()
            val y = Random.nextDouble(360.0).toString()
            return ObservableOrientation(x, z, y)
        }
    }

    constructor(other: ObservableOrientation) : this(other.xAxis, other.zAxis, other.yAxis)

    val xAxisProperty = SimpleStringProperty(xAxis)
    var xAxis: String? by xAxisProperty

    val zAxisProperty = SimpleStringProperty(zAxis)
    var zAxis: String? by zAxisProperty

    val yAxisProperty = SimpleStringProperty(yAxis)
    var yAxis: String? by yAxisProperty

    val valid: Boolean get() = xAxis.isDouble() && zAxis.isDouble() && yAxis.isDouble()
}