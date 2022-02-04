package com.github.mihowjingle.cartographer.ui.views

import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType
import com.github.mihowjingle.cartographer.ui.controllers.ApplicationController
import com.github.mihowjingle.cartographer.ui.converters.PebbleTypeConverter
import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import com.github.mihowjingle.cartographer.ui.model.entities.ObservablePebble
import javafx.beans.property.SimpleObjectProperty
import tornadofx.*

class PebbleCreateView : Fragment() {

    private val controller: ApplicationController by inject()

    private val typeProperty = SimpleObjectProperty<PebbleType>()
    private val position = ObservablePosition(0.0, 0.0, 0.0)

    override val root = form {
        fieldset("Creating a pebble") {
            field("Type") {
                combobox(typeProperty) {
                    maxWidth = Double.MAX_VALUE
                    items = PebbleType.values().toList().toObservable()
                    converter = PebbleTypeConverter
                }
            }
            field("Position: x") {
                doubleInputWorkaround(position::x, allowNegative = true)
            }
            field("Position: z") {
                doubleInputWorkaround(position::z, allowNegative = true)
            }
            field("Position: y") {
                doubleInputWorkaround(position::y, allowNegative = true)
            }
            field {
                button("Cancel").action {
                    close()
                }
                button("Commit") {
                    action {
                        controller.currentLevel.pebbles.add(ObservablePebble(typeProperty.value, position))
                        close()
                    }
                    enableWhen {
                        typeProperty.isNotNull
                    }
                }
            }
        }
    }
}