package com.github.mihowjingle.cartographer.ui.model.level

import com.github.mihowjingle.cartographer.model.level.SensorManagerCameraDistances
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

/**
 * UI version of [SensorManagerCameraDistances]
 */
class ObservableSMCD(min: String? = null, max: String? = null) {

    val minProperty = SimpleStringProperty(min)
    var min: String? by minProperty

    val maxProperty = SimpleStringProperty(max)
    var max: String? by maxProperty

    val valid: Boolean get() {
        val min = min?.toDoubleOrNull() ?: return false
        val max = max?.toDoubleOrNull() ?: return false
        return min > 0.0 && max > 0.0 && min <= max
    }

    fun toPersistent(): SensorManagerCameraDistances {
        return SensorManagerCameraDistances(
            min = min?.toDouble() ?: error("Sensor manager camera distances (min) should not be null at this point!"),
            max = max?.toDouble() ?: error("Sensor manager camera distances (max) should not be null at this point!")
        )
    }
}