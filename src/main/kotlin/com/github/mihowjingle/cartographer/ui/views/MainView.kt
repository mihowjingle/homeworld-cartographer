package com.github.mihowjingle.cartographer.ui.views

import com.github.mihowjingle.cartographer.function.strings.canBecomeDouble
import com.github.mihowjingle.cartographer.model.dictionaries.Background
import com.github.mihowjingle.cartographer.model.dictionaries.FogType
import com.github.mihowjingle.cartographer.model.dictionaries.Music
import com.github.mihowjingle.cartographer.ui.controllers.ApplicationController
import com.github.mihowjingle.cartographer.ui.views.pebble.PebbleCreateView
import com.github.mihowjingle.cartographer.ui.views.pebble.PebbleTableView
import javafx.beans.property.SimpleBooleanProperty
import javafx.geometry.Insets
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.paint.Color
import tornadofx.*
import kotlin.system.exitProcess
import javafx.scene.layout.Background as FXBackground

class MainView : View("Homeworld Cartographer") {

    private val controller: ApplicationController by inject()

    private val sizeValid = SimpleBooleanProperty(controller.currentLevel.size.valid)
    private val smcdValid = SimpleBooleanProperty(controller.currentLevel.sensorsManagerCameraDistances.valid)
    private val fogValid = SimpleBooleanProperty(controller.currentLevel.fog.valid)
    private val levelInfoValid = SimpleBooleanProperty(controller.currentLevel.infoValid)

    override val root = vbox {
        menubar {
            menu("File") {
                item("New", "Ctrl+N")
                item("Load", "Ctrl+L")
                item("Save", "Ctrl+S") {
                    action(controller::save)
                    enableWhen {
                        sizeValid.and(smcdValid).and(fogValid).and(levelInfoValid)
                    }
                }
                separator()
                item("Quit", "Ctrl+Q").action {
                    exitProcess(0)
                }
            }
            menu("Show") {
                item("Asteroids")
                item("Clouds")
                item("Dust clouds")
                item("Megaliths")
                item("Nebulae")
                item("Pebbles").action {
                    find<PebbleTableView>().openWindow()
                }
                item("Salvage")
                item("Starting positions")
                separator()
                item("All objects")
            }
            menu("Add object") {
                item("Asteroid")
                item("Cloud")
                item("Dust cloud")
                item("Megalith")
                item("Nebula")
                item("Pebble").action {
                    find<PebbleCreateView>().openModal()
                }
                item("Salvage")
                //item("Starting position") todo either add/remove on-change of maxPlayers or maxPlayers is readonly and simply = startingPositions.count
            }
            menu("History") {
                item("Undo and stuff...")
            }
            menu("Batch generate") {
                item("Stuff 1")
                item("Stuff 2")
                item("... and so on")
            }
            menu("Manipulate") {
                item("Tilt whole level (x/y axis, with/without changing objects' rotations)") // todo maybe merge with "rotate"
                item("Rotate whole level (around z axis)")
                item("Scale whole level")
                item("Randomize")
                item("Orient all starting positions towards center")
                item("Apply gravity (slightly condense groups of objects, dust clouds etc)")
                item("... and so on")
            }
            menu("Clean up") {
                item("Delete out-of-bounds objects")
                item("Delete duplicated (or even just colliding?) objects")
                item("... and so on")
            }
            menu("Examine") {
                item("Count objects")
                item("How far starting positions are from each other, how un/fair it is")
                item("All kinds of diagnostics/reports")
                item("... and so on")
            }
            menu("Help") {
                menu("Reference") {
                    item("Asteroid types")
                    item("Cloud types")
                    item("Dust cloud types")
                    item("Megalith types")
                    item("Nebula types")
                    item("Pebble types")
                    item("Salvage types")
                    item("Starting positions")
                    separator()
                    item("Level")
                    item("Backgrounds")
                    item("Fog")
                    item("Music")
                }
                item("About")
            }
        }
        borderpane {
            left = form {
                maxWidth = 400.0
                fieldset("Level") {
                    field("Author") {
                        textfield(controller.currentLevel.authorProperty)
                    }
                    field("Name") {
                        textfield(controller.currentLevel.nameProperty) {
                            setOnKeyReleased {
                                levelInfoValid.set(controller.currentLevel.infoValid)
                            }
                        }
                    }
                    field("Max players") {
                        spinner(min = 2, max = 8, amountToStepBy = 1, enableScroll = true, editable = true, property = controller.currentLevel.maxPlayersProperty) {
                            maxWidth = Double.MAX_VALUE
                        }
                    }
                    field("Background") {
                        combobox(controller.currentLevel.backgroundProperty) {
                            maxWidth = Double.MAX_VALUE
                            items = Background.values().map { it.label }.toObservable()
                            setOnAction {
                                levelInfoValid.set(controller.currentLevel.infoValid)
                            }
                        }
                    }
                    field("Default music") {
                        combobox(controller.currentLevel.defaultMusicProperty) {
                            maxWidth = Double.MAX_VALUE
                            items = Music.values().map { it.label }.toObservable()
                            setOnAction {
                                levelInfoValid.set(controller.currentLevel.infoValid)
                            }
                        }
                    }
                    field("Battle music") {
                        combobox(controller.currentLevel.battleMusicProperty) {
                            maxWidth = Double.MAX_VALUE
                            items = Music.values().map { it.label }.toObservable()
                            setOnAction {
                                levelInfoValid.set(controller.currentLevel.infoValid)
                            }
                        }
                    }
                }
                fieldset("Size") {
                    field("X") {
                        textfield(controller.currentLevel.size.xProperty) {
                            filterInput {
                                it.controlNewText.canBecomeDouble(allowNegative = false)
                            }
                            setOnKeyReleased {
                                sizeValid.set(controller.currentLevel.size.valid)
                            }
                        }
                    }
                    field("Z") {
                        textfield(controller.currentLevel.size.zProperty) {
                            filterInput {
                                it.controlNewText.canBecomeDouble(allowNegative = false)
                            }
                            setOnKeyReleased {
                                sizeValid.set(controller.currentLevel.size.valid)
                            }
                        }
                    }
                    field("Y") {
                        textfield(controller.currentLevel.size.yProperty) {
                            filterInput {
                                it.controlNewText.canBecomeDouble(allowNegative = false)
                            }
                            setOnKeyReleased {
                                sizeValid.set(controller.currentLevel.size.valid)
                            }
                        }
                    }
                }
                fieldset("Sensor manager camera distances") {
                    field("Min") {
                        textfield(controller.currentLevel.sensorsManagerCameraDistances.minProperty) {
                            filterInput {
                                it.controlNewText.canBecomeDouble(allowNegative = false)
                            }
                            setOnKeyReleased {
                                smcdValid.set(controller.currentLevel.sensorsManagerCameraDistances.valid)
                            }
                        }
                    }
                    field("Max") {
                        textfield(controller.currentLevel.sensorsManagerCameraDistances.maxProperty) {
                            filterInput {
                                it.controlNewText.canBecomeDouble(allowNegative = false)
                            }
                            setOnKeyReleased {
                                smcdValid.set(controller.currentLevel.sensorsManagerCameraDistances.valid)
                            }
                        }
                    }
                }
                fieldset("Fog") {
                    field("Active") {
                        checkbox(property = controller.currentLevel.fog.activeProperty) {
                            setOnAction {
                                fogValid.set(controller.currentLevel.fog.valid)
                            }
                        }
                    }
                    field("Type") {
                        combobox(controller.currentLevel.fog.typeProperty) {
                            maxWidth = Double.MAX_VALUE
                            items = FogType.values().map { it.label }.toObservable()
                            enableWhen {
                                controller.currentLevel.fog.activeProperty
                            }
                            setOnAction {
                                fogValid.set(controller.currentLevel.fog.valid)
                            }
                        }
                    }
                    field("Start") {
                        textfield(controller.currentLevel.fog.startProperty) {
                            filterInput {
                                it.controlNewText.canBecomeDouble(allowNegative = false)
                            }
                            setOnKeyReleased {
                                fogValid.set(controller.currentLevel.fog.valid)
                            }
                            enableWhen {
                                controller.currentLevel.fog.activeProperty
                            }
                        }
                    }
                    field("End") {
                        textfield(controller.currentLevel.fog.endProperty) {
                            filterInput {
                                it.controlNewText.canBecomeDouble(allowNegative = false)
                            }
                            setOnKeyReleased {
                                fogValid.set(controller.currentLevel.fog.valid)
                            }
                            enableWhen {
                                controller.currentLevel.fog.activeProperty
                            }
                        }
                    }
                    field("Color") {
                        colorpicker(controller.currentLevel.fog.colorProperty) {
                            maxWidth = Double.MAX_VALUE
                            enableWhen {
                                controller.currentLevel.fog.activeProperty
                            }
                        }
                    }
                    field("Density") {
                        textfield(controller.currentLevel.fog.densityProperty) {
                            filterInput {
                                it.controlNewText.canBecomeDouble(allowNegative = false)
                            }
                            setOnKeyReleased {
                                fogValid.set(controller.currentLevel.fog.valid)
                            }
                            enableWhen {
                                controller.currentLevel.fog.activeProperty
                            }
                        }
                    }
                }
            }
            center = pane {
                background = FXBackground(BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY))
                imageview("3dviewer.png")
            }
        }
    }
}