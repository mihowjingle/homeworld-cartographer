package com.github.mihowjingle.cartographer.ui.model.level

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
    start: String? = null,
    end: String? = null,
    color: Color = Color(1.0, 1.0, 1.0, 1.0),
    density: String? = null
) {

    val activeProperty = SimpleBooleanProperty(active)
    var active: Boolean by activeProperty

    val typeProperty = SimpleObjectProperty(type)
    var type: FogType? by typeProperty

    val startProperty = SimpleStringProperty(start)
    var start: String? by startProperty

    val endProperty = SimpleStringProperty(end)
    var end: String? by endProperty

    val colorProperty = SimpleObjectProperty(color)
    var color: Color by colorProperty

    val densityProperty = SimpleStringProperty(density)
    var density: String? by densityProperty

    override fun toString(): String {
        return "ObservableFog(active=$active, type=$type, start=$start, end=$end, color=$color, density=$density)"
    }

    val valid: Boolean get() {
        if (!active) {
            return true
        }
        val start = start?.toDoubleOrNull() ?: return false
        val end = end?.toDoubleOrNull() ?: return false
        val density = density?.toDoubleOrNull() ?: return false
        return type != null && start > 0.0 && end > 0.0 && start <= end && density > 0.0 && density <= 1.0
    }

    fun toPersistent(): Fog {
        return Fog(
            active = active,
            type = type,
            start = start?.toDouble(),
            end = end?.toDouble(),
            color = PersistentColor(color.red, color.green, color.blue, color.opacity),
            density = density?.toDouble()
        )
    }
}