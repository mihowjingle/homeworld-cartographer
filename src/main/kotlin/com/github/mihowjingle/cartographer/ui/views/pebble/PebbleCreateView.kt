package com.github.mihowjingle.cartographer.ui.views.pebble

import com.github.mihowjingle.cartographer.function.strings.canBecomeDouble
import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType
import com.github.mihowjingle.cartographer.ui.controllers.ApplicationController
import com.github.mihowjingle.cartographer.ui.converters.PebbleTypeConverter
import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import com.github.mihowjingle.cartographer.ui.model.entities.ObservablePebble
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleObjectProperty
import tornadofx.*

class PebbleCreateView : Fragment() {

    private val controller: ApplicationController by inject()

    private val typeProperty = SimpleObjectProperty<PebbleType>()
    private val position = ObservablePosition()

    private val positionValid = SimpleBooleanProperty(false)

    private fun saveAndClose() {
        controller.currentLevel.pebbles.add(ObservablePebble(typeProperty.value, position)) // todo controller method?
        close()
    }

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
                textfield(position.xProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(position.valid)
                    }
                    setOnAction {
                        if (typeProperty.isNotNull.and(positionValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Position: z") {
                textfield(position.zProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(position.valid)
                    }
                    setOnAction {
                        if (typeProperty.isNotNull.and(positionValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Position: y") {
                textfield(position.yProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(position.valid)
                    }
                    setOnAction {
                        if (typeProperty.isNotNull.and(positionValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field {
                button("Cancel").action {
                    close()
                }
                button("Save") {
                    action {
                        saveAndClose()
                    }
                    enableWhen {
                        typeProperty.isNotNull.and(positionValid)
                    }
                }
            }
        }
    }
}