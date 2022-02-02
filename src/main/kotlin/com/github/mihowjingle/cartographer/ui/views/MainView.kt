package com.github.mihowjingle.cartographer.ui.views

import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType
import com.github.mihowjingle.cartographer.model.entities.Pebble
import tornadofx.*
import kotlin.system.exitProcess

class MainView : View("Homeworld Cartographer") {
    override val root = vbox {
        menubar { // just an example, up for radical change, probably
            menu("File") {
                item("New", "Ctrl+N")
                item("Import", "Ctrl+I") // .level
                item("Export", "Ctrl+E") // .level
                item("Load", "Ctrl+L") // some kind of my own intermediate file type, with some extra metadata? maybe?
                item("Save", "Ctrl+S") // some kind of my own intermediate file type, with some extra metadata? maybe?
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
                item("Pebbles! :)").action {
                    find<PebblesModal>(mapOf(PebblesModal::pebbles to listOf(
                        Pebble(PebbleType.PEBBLE_0, Position(1.0, 2.0, 3.0)),
                        Pebble(PebbleType.PEBBLE_1, Position(11.0, 12.0, 13.0)),
                        Pebble(PebbleType.PEBBLE_2, Position(21.0, 22.0, 23.0))
                    ))).openWindow()
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
                item("Pebble")
                item("Salvage")
                item("Starting position")
            }
            menu("Batch generate") {
                item("Stuff 1")
                item("Stuff 2")
                item("... and so on")
            }
            menu("Manipulate") {
                item("Tilt whole level")
                item("Scale whole level")
                item("Randomize")
                item("... and so on")
            }
            menu("Clean up") {
                item("Delete out-of-bounds objects")
                item("Delete duplicated (or even just colliding?) objects")
                item("... and so on")
            }
            menu("Examine") {
                item("Count objects")
                item("All kinds of diagnostics/reports")
                item("Dunno")
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
        hbox {
            borderpane {
                left = form {
                    fieldset("Level") {
                        field("Author") {
                            textfield()
                        }
                        field("Name") {
                            textfield()
                        }
                        field("Max players") {
                            spinner<Int>()
                        }
                        field("Background") {
                            combobox<String> {}
                        }
                        field("Default music") {
                            combobox<String> {}
                        }
                        field("Battle music") {
                            combobox<String> {}
                        }
                    }
                    fieldset("Size") {
                        field("X") {
                            spinner<Double>()
                        }
                        field("Z") {
                            spinner<Double>()
                        }
                        field("Y") {
                            spinner<Double>()
                        }
                    }
                    fieldset("Sensor manager camera distances") {
                        field("Min") {
                            spinner<Double>()
                        }
                        field("Max") {
                            spinner<Double>()
                        }
                    }
                    fieldset("Fog") {
                        field("Active") {
                            checkbox()
                        }
                        field("Type") {
                            combobox<String> {}
                        }
                        field("Start") {
                            spinner<Double>()
                        }
                        field("End") {
                            spinner<Double>()
                        }
                        field("Color") {
                            colorpicker()
                        }
                        field("Density") {
                            spinner<Double>()
                        }
                    }
                }
                center = imageview("3dviewer.png")
            }
        }
    }
}