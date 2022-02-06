package com.github.mihowjingle.cartographer.ui.views.pebble

import com.github.mihowjingle.cartographer.function.strings.canBecomeDouble
import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType
import com.github.mihowjingle.cartographer.ui.controllers.ApplicationController
import com.github.mihowjingle.cartographer.ui.model.entities.ObservablePebble
import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

class PebbleEditView : Fragment() {

    val pebble: ObservablePebble by param()

    private val controller: ApplicationController by inject()

    private val editedPebble = ObservablePebble(null)

    private val positionValid = SimpleBooleanProperty(pebble.type != null && pebble.position.valid)

    override fun onDock() {
        pebble copyInto editedPebble
    }

    private fun saveAndClose() {
        editedPebble copyInto pebble
        close()
    }

    override val root = form {
        fieldset("Editing a pebble") {
            field("Type") {
                combobox(editedPebble.typeProperty) {
                    maxWidth = Double.MAX_VALUE
                    items = PebbleType.values().map { it.label }.toObservable()
                }
            }
            field("Position: x") {
                textfield(editedPebble.position.xProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(editedPebble.position.valid)
                    }
                    setOnAction {
                        if (editedPebble.typeProperty.isNotNull.and(positionValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Position: z") {
                textfield(editedPebble.position.zProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(editedPebble.position.valid)
                    }
                    setOnAction {
                        if (editedPebble.typeProperty.isNotNull.and(positionValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Position: y") {
                textfield(editedPebble.position.yProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(editedPebble.position.valid)
                    }
                    setOnAction {
                        if (editedPebble.typeProperty.isNotNull.and(positionValid).value) {
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
                        editedPebble.typeProperty.isNotNull.and(positionValid)
                    }
                }
                button("Delete").action {
                    controller.currentLevel.pebbles.remove(pebble)
                    close()
                }
            }
        }
    }
}