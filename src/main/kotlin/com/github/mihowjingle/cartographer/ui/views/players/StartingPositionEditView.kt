package com.github.mihowjingle.cartographer.ui.views.players

import com.github.mihowjingle.cartographer.function.strings.canBecomeDouble
import com.github.mihowjingle.cartographer.ui.controllers.ApplicationController
import com.github.mihowjingle.cartographer.ui.model.entities.ObservableStartingPosition
import javafx.beans.binding.Bindings
import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*


class StartingPositionEditView : Fragment() {

    val startingPosition: ObservableStartingPosition by param()

    private val controller: ApplicationController by inject()

    private val editedStartingPosition = ObservableStartingPosition(startingPosition.playerIndex)

    private val valid = SimpleBooleanProperty(startingPosition.valid)

    override fun onDock() {
        startingPosition copyInto editedStartingPosition
    }

    private fun saveAndClose() {
        editedStartingPosition copyInto startingPosition
        close()
        controller.recheckStartingPositionsValid()
    }

    override val root = form {
        fieldset("Editing a startingPosition") {
            field("Position: x") {
                textfield(editedStartingPosition.position.xProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        valid.set(editedStartingPosition.valid)
                    }
                    setOnAction {
                        if (valid.value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Position: z") {
                textfield(editedStartingPosition.position.zProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        valid.set(editedStartingPosition.valid)
                    }
                    setOnAction {
                        if (valid.value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Position: y") {
                textfield(editedStartingPosition.position.yProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        valid.set(editedStartingPosition.valid)
                    }
                    setOnAction {
                        if (valid.value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Orientation: z axis") {
                textfield(editedStartingPosition.zAxisOrientationProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        valid.set(editedStartingPosition.valid)
                    }
                    setOnAction {
                        if (valid.value) {
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
                        valid
                    }
                }
                button("Delete"){
                    action {
                        controller.remove(startingPosition)
                        close()
                    }
                    enableWhen {
                        Bindings.size(controller.currentLevel.startingPositions).greaterThan(2)
                    }
                }
            }
        }
    }
}