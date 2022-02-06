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
}