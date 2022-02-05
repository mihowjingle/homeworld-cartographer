package com.github.mihowjingle.cartographer.ui.views.pebble

import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType
import com.github.mihowjingle.cartographer.ui.controllers.ApplicationController
import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import com.github.mihowjingle.cartographer.ui.model.entities.ObservablePebble
import com.github.mihowjingle.cartographer.function.strings.canBecomeDouble
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class PebbleEditView : Fragment() {

    val pebble: ObservablePebble by param()

    private val controller: ApplicationController by inject()

    private val typeProperty = SimpleStringProperty()
    private val position = ObservablePosition()

    private val positionValid = SimpleBooleanProperty(pebble.type != null && pebble.position.valid)

    override fun onDock() {
        typeProperty.value = pebble.type
        position.x = pebble.position.x
        position.z = pebble.position.z
        position.y = pebble.position.y
    }

    private fun saveAndClose() {
        pebble.type = typeProperty.value
        pebble.position.x = position.x
        pebble.position.z = position.z
        pebble.position.y = position.y
        close()
    }

    override val root = form {
        fieldset("Editing a pebble") {
            field("Type") {
                combobox(typeProperty) {
                    maxWidth = Double.MAX_VALUE
                    items = PebbleType.values().map { it.label }.toObservable()
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
                button("Delete").action {
                    controller.currentLevel.pebbles.remove(pebble)
                    close()
                }
            }
        }
    }
}