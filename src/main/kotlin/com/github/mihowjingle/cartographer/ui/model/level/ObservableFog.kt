package com.github.mihowjingle.cartographer.ui.model.level

import com.github.mihowjingle.cartographer.model.dictionaries.FogType
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleDoubleProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.scene.paint.Color
import tornadofx.getValue
import tornadofx.setValue

class ObservableFog(
    active: Boolean = false,
    type: FogType? = null,
    start: Double = 0.0,
    end: Double = 0.0,
    color: Color = Color(1.0, 1.0, 1.0, 1.0),
    density: Double = 0.0
) {

    val activeProperty = SimpleBooleanProperty(active)
    var active: Boolean by activeProperty

    val typeProperty = SimpleObjectProperty(type)
    var type: FogType? by typeProperty

    // todo private for now, until spinner is fixed for Double
    //  and i can get rid of the workaround
    //  btw file issue?
    private val startProperty = SimpleDoubleProperty(start)
    var start: Double by startProperty

    private val endProperty = SimpleDoubleProperty(end)
    var end: Double by endProperty

    val colorProperty = SimpleObjectProperty(color)
    var color: Color by colorProperty

    private val densityProperty = SimpleDoubleProperty(density)
    var density: Double by densityProperty

    override fun toString(): String {
        return "ObservableFog(active=$active, type=$type, start=$start, end=$end, color=$color, density=$density)"
    }
}