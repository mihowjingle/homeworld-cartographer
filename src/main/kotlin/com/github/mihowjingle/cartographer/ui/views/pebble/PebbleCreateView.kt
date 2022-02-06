package com.github.mihowjingle.cartographer.ui.views.pebble

import com.github.mihowjingle.cartographer.function.strings.canBecomeDouble
import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType
import com.github.mihowjingle.cartographer.ui.controllers.ApplicationController
import com.github.mihowjingle.cartographer.ui.model.entities.ObservablePebble
import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

class PebbleCreateView : Fragment() {

    private val controller: ApplicationController by inject()

    private val pebble = ObservablePebble(null)

    private val positionValid = SimpleBooleanProperty(false)

    private fun saveAndClose() {
        controller.currentLevel.pebbles.add(pebble) // todo controller method?
        close()
    }

    override val root = form {
        fieldset("Creating a pebble") {
            field("Type") {
                combobox(pebble.typeProperty) {
                    maxWidth = Double.MAX_VALUE
                    items = PebbleType.values().map { it.label }.toObservable()
                }
            }
            field("Position: x") {
                textfield(pebble.position.xProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(pebble.position.valid)
                    }
                    setOnAction {
                        if (pebble.typeProperty.isNotNull.and(positionValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Position: z") {
                textfield(pebble.position.zProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(pebble.position.valid)
                    }
                    setOnAction {
                        if (pebble.typeProperty.isNotNull.and(positionValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Position: y") {
                textfield(pebble.position.yProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(pebble.position.valid)
                    }
                    setOnAction {
                        if (pebble.typeProperty.isNotNull.and(positionValid).value) {
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
                        pebble.typeProperty.isNotNull.and(positionValid)
                    }
                }
            }
        }
    }
}