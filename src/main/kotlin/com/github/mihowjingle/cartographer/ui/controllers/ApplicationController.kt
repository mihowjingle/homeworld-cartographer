package com.github.mihowjingle.cartographer.ui.controllers

import com.github.mihowjingle.cartographer.function.level.toLua
import com.github.mihowjingle.cartographer.function.level.toPersistent
import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.entities.StartingPosition
import com.github.mihowjingle.cartographer.ui.model.entities.ObservableAsteroid
import com.github.mihowjingle.cartographer.ui.model.entities.ObservablePebble
import com.github.mihowjingle.cartographer.ui.model.level.ObservableLevel
import javafx.stage.FileChooser
import tornadofx.Controller
import tornadofx.FileChooserMode
import tornadofx.chooseFile
import kotlin.math.min

class ApplicationController : Controller() {

    val currentLevel = ObservableLevel()

    fun save() {
        val levelLuaString = currentLevel.toPersistent().toLua()
        val files = chooseFile(
            mode = FileChooserMode.Save,
            filters = arrayOf(
                FileChooser.ExtensionFilter(
                    "Homeworld Remastered Collection Level File",
                    "*.level"
                )
            )
        ) {
            initialFileName = "${currentLevel.name}.level"
        }
        if (files.size > 1) {
            throw IllegalStateException("Multiple files to save to?")
        }
        if (files.isEmpty()) {
            return // user must've cancelled
        }
        val file = files[0]
        file.writeText(levelLuaString)
    }

    fun addPebble(pebble: ObservablePebble) {
        currentLevel.pebbles.add(pebble)
    }

    fun addAsteroid(asteroid: ObservableAsteroid) {
        currentLevel.asteroids.add(asteroid)
    }

    fun syncStartingPositions(oldValue: Int, newValue: Int) {
        with(currentLevel.startingPositions) {
            if (oldValue > newValue) {
                remove(newValue, size)
            }
            if (oldValue < newValue) {
                while (size < min(newValue, 8)) {
                    add(StartingPosition(size, Position(0.0, 0.0, 0.0), 0.0))
                }
            }
        }
    }
}