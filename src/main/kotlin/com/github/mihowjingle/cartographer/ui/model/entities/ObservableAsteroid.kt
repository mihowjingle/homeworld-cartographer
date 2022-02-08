package com.github.mihowjingle.cartographer.ui.model.entities

import com.github.mihowjingle.cartographer.delegate.FxDoublePropertyDelegate
import com.github.mihowjingle.cartographer.model.dictionaries.AsteroidType
import com.github.mihowjingle.cartographer.model.entities.Asteroid
import com.github.mihowjingle.cartographer.ui.model.common.ObservableOrientation
import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import javafx.beans.property.SimpleStringProperty

/**
 * UI version of [Asteroid]
 */
class ObservableAsteroid(
    type: AsteroidType?,
    percentOfDefaultRus: Double? = 100.0,
    val position: ObservablePosition = ObservablePosition(),
    val initialOrientation: ObservableOrientation = ObservableOrientation()
) {

    val typeProperty = SimpleStringProperty(type?.label)
    var type: AsteroidType?
        get() {
            return AsteroidType.values().find { it.label == typeProperty.value }
        }
        set(value) {
            typeProperty.value = value?.label
        }

    val percentOfDefaultRusProperty = SimpleStringProperty(percentOfDefaultRus?.toString())
    var percentOfDefaultRus: Double? by FxDoublePropertyDelegate(percentOfDefaultRusProperty)

    val effectiveRusProperty = SimpleStringProperty()
    var effectiveRus: Double? by FxDoublePropertyDelegate(effectiveRusProperty)

    // for tableview columns only
    val xProperty by position::xProperty
    val zProperty by position::zProperty
    val yProperty by position::yProperty
    val initialOrientationXAxisProperty by initialOrientation::xAxisProperty
    val initialOrientationZAxisProperty by initialOrientation::zAxisProperty
    val initialOrientationYAxisProperty by initialOrientation::yAxisProperty

    fun toPersistent(): Asteroid {
        val type = type ?: error("Pebble type should not be null at this point!")
        val percentOfDefaultRus = percentOfDefaultRus ?: error("Percent of default RUs should not be null at this point!")
        return Asteroid(type, position.toPersistent(), percentOfDefaultRus, initialOrientation.toPersistent())
    }

    infix fun copyInto(other: ObservableAsteroid) {
        other.type = this.type
        other.percentOfDefaultRus = this.percentOfDefaultRus
        other.effectiveRus = this.effectiveRus
        this.position copyInto other.position
        this.initialOrientation copyInto other.initialOrientation
    }
}