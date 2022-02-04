package com.github.mihowjingle.cartographer.ui.views

import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType
import com.github.mihowjingle.cartographer.ui.converters.PebbleTypeConverter
import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import com.github.mihowjingle.cartographer.ui.model.entities.ObservablePebble
import javafx.beans.property.SimpleObjectProperty
import tornadofx.*

class PebbleEditView : Fragment() {

    val pebble: ObservablePebble by param()

    private val typeProperty = SimpleObjectProperty<PebbleType>()
    private val position = ObservablePosition(0.0, 0.0, 0.0)

    override fun onDock() {
        typeProperty.value = pebble.type
        position.x = pebble.position.x
        position.z = pebble.position.z
        position.y = pebble.position.y
    }

    override val root = form {
        fieldset("Editing a pebble") {
            field("Type") {
                combobox(typeProperty) {
                    maxWidth = Double.MAX_VALUE
                    items = PebbleType.values().toList().toObservable()
                    converter = PebbleTypeConverter
                }
            }
            field("Position: x") {
                doubleInputWorkaround(position::x, initialValue = pebble.position.x.toString(), allowNegative = true)
            }
            field("Position: z") {
                doubleInputWorkaround(position::z, initialValue = pebble.position.z.toString(), allowNegative = true)
            }
            field("Position: y") {
                doubleInputWorkaround(position::y, initialValue = pebble.position.y.toString(), allowNegative = true)
            }
            field {
                button("Cancel").action {
                    close()
                }
                button("Commit") {
                    action {
                        pebble.type = typeProperty.value
                        pebble.position.x = position.x
                        pebble.position.z = position.z
                        pebble.position.y = position.y
                        close()
                    }
                }
            }
        }
    }
}