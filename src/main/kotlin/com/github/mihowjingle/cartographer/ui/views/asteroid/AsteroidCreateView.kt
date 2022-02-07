package com.github.mihowjingle.cartographer.ui.views.asteroid

import com.github.mihowjingle.cartographer.function.strings.canBecomeDouble
import com.github.mihowjingle.cartographer.model.dictionaries.AsteroidType
import com.github.mihowjingle.cartographer.ui.controllers.ApplicationController
import com.github.mihowjingle.cartographer.ui.model.entities.ObservableAsteroid
import javafx.beans.property.SimpleBooleanProperty
import tornadofx.*

class AsteroidCreateView : Fragment() {

    private val controller: ApplicationController by inject()

    private val asteroid = ObservableAsteroid(null)

    private val positionValid = SimpleBooleanProperty(false)
    private val percentOfDefaultRusValid = SimpleBooleanProperty(true)
    private val orientationValid = SimpleBooleanProperty(false)

    private fun saveAndClose() {
        controller.addAsteroid(asteroid)
        close()
    }

    override val root = form {
        fieldset("Creating an asteroid") {
            field("Type") {
                combobox(asteroid.typeProperty) {
                    maxWidth = Double.MAX_VALUE
                    items = AsteroidType.values().map { it.label }.toObservable()
                    setOnAction {
                        val pdr = asteroid.percentOfDefaultRus
                        val effectiveRus = asteroid.effectiveRus
                        val type = asteroid.type

                        if (type != null) {
                            if (type.defaultRus == 0) {
                                asteroid.effectiveRus = 0.0
                            } else if (pdr != null) {
                                asteroid.effectiveRus = pdr * type.defaultRus / 100
                            } else if (effectiveRus != null) {
                                asteroid.percentOfDefaultRus = effectiveRus * 100 / type.defaultRus
                            }
                        }
                    }
                }
            }
            field("Position: x") {
                textfield(asteroid.position.xProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(asteroid.position.valid)
                    }
                    setOnAction {
                        if (asteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Position: z") {
                textfield(asteroid.position.zProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(asteroid.position.valid)
                    }
                    setOnAction {
                        if (asteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Position: y") {
                textfield(asteroid.position.yProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        positionValid.set(asteroid.position.valid)
                    }
                    setOnAction {
                        if (asteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("% of default RUs") {
                textfield(asteroid.percentOfDefaultRusProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = false)
                    }
                    setOnKeyReleased {
                        val pdr = asteroid.percentOfDefaultRus
                        val type = asteroid.type

                        percentOfDefaultRusValid.set(pdr != null)
                        if (pdr != null && type != null) {
                            asteroid.effectiveRus = pdr * type.defaultRus / 100
                        } else {
                            asteroid.effectiveRus = null
                        }
                    }
                    setOnAction {
                        if (asteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Effective RUs") {
                textfield(asteroid.effectiveRusProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = false)
                    }
                    setOnKeyReleased {
                        val effectiveRus = asteroid.effectiveRus
                        val type = asteroid.type

                        if (type != null && type.defaultRus == 0) {
                            asteroid.percentOfDefaultRus = 0.0
                        } else if (effectiveRus != null && type != null) {
                            asteroid.percentOfDefaultRus = effectiveRus * 100 / type.defaultRus
                        } else {
                            asteroid.percentOfDefaultRus = null
                        }
                        val pdr = asteroid.percentOfDefaultRus
                        percentOfDefaultRusValid.set(pdr != null)
                    }
                    setOnAction {
                        if (asteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Initial orientation: x axis") {
                textfield(asteroid.initialOrientation.xAxisProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        orientationValid.set(asteroid.initialOrientation.valid)
                    }
                    setOnAction {
                        if (asteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Initial orientation: z axis") {
                textfield(asteroid.initialOrientation.zAxisProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        orientationValid.set(asteroid.initialOrientation.valid)
                    }
                    setOnAction {
                        if (asteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
                            saveAndClose()
                        }
                    }
                }
            }
            field("Initial orientation: y axis") {
                textfield(asteroid.initialOrientation.yAxisProperty) {
                    filterInput {
                        it.controlNewText.canBecomeDouble(allowNegative = true)
                    }
                    setOnKeyReleased {
                        orientationValid.set(asteroid.initialOrientation.valid)
                    }
                    setOnAction {
                        if (asteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid).value) {
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
                        asteroid.typeProperty.isNotNull.and(positionValid).and(percentOfDefaultRusValid).and(orientationValid)
                    }
                }
            }
        }
    }
}