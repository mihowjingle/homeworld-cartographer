package com.github.mihowjingle.cartographer.ui.model.level

import com.github.mihowjingle.cartographer.delegate.FxDoublePropertyDelegate
import com.github.mihowjingle.cartographer.model.dictionaries.FogType
import com.github.mihowjingle.cartographer.model.level.Fog
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.scene.paint.Color
import tornadofx.getValue
import tornadofx.setValue
import com.github.mihowjingle.cartographer.model.common.Color as PersistentColor

/**
 * UI version of [Fog]
 */
class ObservableFog(
    active: Boolean = false,
    type: FogType? = null,
    start: Double? = null,
    end: Double? = null,
    color: Color = Color(1.0, 1.0, 1.0, 1.0),
    density: Double? = null
) {

    val activeProperty = SimpleBooleanProperty(active)
    var active: Boolean by activeProperty

    val typeProperty = SimpleObjectProperty(type)
    var type: FogType? by typeProperty

    val startProperty = SimpleStringProperty(start?.toString())
    var start: Double? by FxDoublePropertyDelegate(startProperty)

    val endProperty = SimpleStringProperty(end?.toString())
    var end: Double? by FxDoublePropertyDelegate(endProperty)

    val colorProperty = SimpleObjectProperty(color)
    var color: Color by colorProperty

    val densityProperty = SimpleStringProperty(density?.toString())
    var density: Double? by FxDoublePropertyDelegate(densityProperty)

    override fun toString(): String {
        return "ObservableFog(active=$active, type=$type, start=$start, end=$end, color=$color, density=$density)"
    }

    val valid: Boolean get() {
        if (!active) {
            return true
        }
        val start = start ?: return false
        val end = end ?: return false
        val density = density ?: return false
        return type != null && start > 0.0 && end > 0.0 && start <= end && density > 0.0 && density <= 1.0
    }

    fun toPersistent(): Fog {
        return Fog(
            active = active,
            type = type,
            start = start,
            end = end,
            color = PersistentColor(color.red, color.green, color.blue, color.opacity),
            density = density
        )
    }
}