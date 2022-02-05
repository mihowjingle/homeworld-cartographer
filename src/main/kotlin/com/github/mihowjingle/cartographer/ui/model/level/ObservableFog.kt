package com.github.mihowjingle.cartographer.ui.model.level

import com.github.mihowjingle.cartographer.model.dictionaries.FogType
import com.github.mihowjingle.cartographer.model.level.Fog
import com.github.mihowjingle.cartographer.ui.model.common.ObservableConstraint
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
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
    type: String? = null,
    start: Double = 0.0,
    end: Double = 0.0,
    color: Color = Color(1.0, 1.0, 1.0, 1.0),
    density: Double = 0.0
) {

    val activeProperty = SimpleBooleanProperty(active)
    var active: Boolean by activeProperty

    val typeProperty = SimpleStringProperty(type)
    var type: String? by typeProperty

    val gradient = ObservableConstraint(start, end)

    val colorProperty = SimpleObjectProperty(color)
    var color: Color by colorProperty

    // todo private for now, until spinner is fixed for Double
    //  and i can get rid of the workaround
    //  btw file issue?
    private val densityProperty = SimpleDoubleProperty(density)
    var density: Double by densityProperty

    override fun toString(): String {
        return "ObservableFog(active=$active, type=$type, gradient=$gradient, color=$color, density=$density)"
    }

    fun toPersistent(): Fog {
        return Fog(
            active = active,
            type = FogType.values().find { it.label == type },
            start = gradient.min,
            end = gradient.max,
            color = PersistentColor(color.red, color.green, color.blue, color.opacity),
            density = density
        )
    }
}