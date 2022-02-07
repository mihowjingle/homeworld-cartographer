package com.github.mihowjingle.cartographer.ui.views.asteroid

import com.github.mihowjingle.cartographer.function.strings.canBecomeDouble
import com.github.mihowjingle.cartographer.model.dictionaries.AsteroidType
import com.github.mihowjingle.cartographer.ui.controllers.ApplicationController
import com.github.mihowjingle.cartographer.ui.model.entities.ObservableAsteroid
import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

class AsteroidEditView : Fragment() {

    private val controller: ApplicationController by inject()

    val asteroid: ObservableAsteroid by param()
    private val editedAsteroid = ObservableAsteroid(null)

    private val positionValid = SimpleBooleanProperty(asteroid.position.valid)
    private val percentOfDefaultRusValid = SimpleBooleanProperty(asteroid.percentOfDefaultRus != null)
    private val orientationValid = SimpleBooleanProperty(asteroid.initialOrientation.valid)

    override fun onDock() {
        asteroid copyInto editedAsteroid
    }

    private fun saveAndClose() {
        editedAsteroid copyInto asteroid
        close()
    }

    override val root = form {
        fieldset("Editing an asteroid") {
            field("Type") {
                combobox(editedAsteroid.typeProperty) {
                    maxWidth = Double.MAX_VALUE
                    items = AsteroidType.values().map { it.label }.toObservable()
                    setOnAction {
                        val pdr = editedAsteroid.percentOfDefaultRus
                        val effectiveRus = editedAsteroid.effectiveRus
                        val type = editedAsteroid.type

                        if (type != null) {
                            if (type.defaultRus == 0) {
                                editedAsteroid.effectiveRus = 0.0
                            } else if (pdr != null) {
                                editedAsteroid.effectiveRus = pdr * type.defaultRus / 100
                            } else if (effectiveRus != null) {
                                editedAsteroid.percentOfDefaultRus = effectiveRus * 100 / type.defaultRus
                            }
                        }
                    }
                }
            }
            field("Position: x") {
                textfield(editedAsteroid.position.xProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(editedAsteroid.position.valid)
                    }
                    setOnAction {
                        if (editedAsteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Position: z") {
                textfield(editedAsteroid.position.zProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(editedAsteroid.position.valid)
                    }
                    setOnAction {
                        if (editedAsteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Position: y") {
                textfield(editedAsteroid.position.yProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(editedAsteroid.position.valid)
                    }
                    setOnAction {
                        if (editedAsteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("% of default RUs") {
                textfield(editedAsteroid.percentOfDefaultRusProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = false)
                    }
                    setOnKeyReleased {
                        val pdr = editedAsteroid.percentOfDefaultRus
                        val type = editedAsteroid.type

                        percentOfDefaultRusValid.set(pdr != null)
                        if (pdr != null && type != null) {
                            editedAsteroid.effectiveRus = pdr * type.defaultRus / 100
                        } else {
                            editedAsteroid.effectiveRus = null
                        }
                    }
                    setOnAction {
                        if (editedAsteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Effective RUs") {
                textfield(editedAsteroid.effectiveRusProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = false)
                    }
                    setOnKeyReleased {
                        val effectiveRus = editedAsteroid.effectiveRus
                        val type = editedAsteroid.type

                        if (type != null && type.defaultRus == 0) {
                            editedAsteroid.percentOfDefaultRus = 0.0
                        } else if (effectiveRus != null && type != null) {
                            editedAsteroid.percentOfDefaultRus = effectiveRus * 100 / type.defaultRus
                        } else {
                            editedAsteroid.percentOfDefaultRus = null
                        }
                        val pdr = editedAsteroid.percentOfDefaultRus
                        percentOfDefaultRusValid.set(pdr != null)
                    }
                    setOnAction {
                        if (editedAsteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Initial orientation: x axis") {
                textfield(editedAsteroid.initialOrientation.xAxisProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        orientationValid.set(editedAsteroid.initialOrientation.valid)
                    }
                    setOnAction {
                        if (editedAsteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Initial orientation: z axis") {
                textfield(editedAsteroid.initialOrientation.zAxisProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        orientationValid.set(editedAsteroid.initialOrientation.valid)
                    }
                    setOnAction {
                        if (editedAsteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Initial orientation: y axis") {
                textfield(editedAsteroid.initialOrientation.yAxisProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        orientationValid.set(editedAsteroid.initialOrientation.valid)
                    }
                    setOnAction {
                        if (editedAsteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
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
                        editedAsteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid)
                    }
                }
                button("Delete").action {
                    controller.currentLevel.asteroids.remove(asteroid)
                    close()
                }
            }
        }
    }
}