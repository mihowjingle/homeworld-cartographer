package com.github.mihowjingle.cartographer.ui.model.level

import com.github.mihowjingle.cartographer.delegate.FxDoublePropertyDelegate
import com.github.mihowjingle.cartographer.model.level.SensorManagerCameraDistances
import javafx.beans.property.SimpleStringProperty

/**
 * UI version of [SensorManagerCameraDistances]
 */
class ObservableSMCD(min: Double? = null, max: Double? = null) {

    val minProperty = SimpleStringProperty(min?.toString())
    var min: Double? by FxDoublePropertyDelegate(minProperty)

    val maxProperty = SimpleStringProperty(max?.toString())
    var max: Double? by FxDoublePropertyDelegate(maxProperty)

    val valid: Boolean get() {
        val min = min ?: return false
        val max = max ?: return false
        return min > 0.0 && max > 0.0 && min <= max
    }

    fun toPersistent(): SensorManagerCameraDistances {
        return SensorManagerCameraDistances(
            min = min ?: error("Sensor manager camera distances (min) should not be null at this point!"),
            max = max ?: error("Sensor manager camera distances (max) should not be null at this point!")
        )
    }
}