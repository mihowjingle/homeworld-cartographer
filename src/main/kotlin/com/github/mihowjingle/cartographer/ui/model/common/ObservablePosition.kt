package com.github.mihowjingle.cartographer.ui.model.common

import com.github.mihowjingle.cartographer.function.strings.isDouble
import com.github.mihowjingle.cartographer.model.common.Position
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

/**
 * UI version of [Position]
 */
class ObservablePosition(x: String? = null, z: String? = null, y: String? = null) {

    constructor(other: ObservablePosition) : this(other.x, other.z, other.y)

    val xProperty = SimpleStringProperty(x)
    var x: String? by xProperty

    val zProperty = SimpleStringProperty(z)
    var z: String? by zProperty

    val yProperty = SimpleStringProperty(y)
    var y: String? by yProperty

    val valid: Boolean get() = x.isDouble() && z.isDouble() && y.isDouble()
}