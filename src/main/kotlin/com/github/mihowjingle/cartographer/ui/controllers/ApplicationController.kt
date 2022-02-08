package com.github.mihowjingle.cartographer.ui.controllers

import com.github.mihowjingle.cartographer.function.level.toLua
import com.github.mihowjingle.cartographer.function.level.toPersistent
import com.github.mihowjingle.cartographer.function.players.valid
import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import com.github.mihowjingle.cartographer.ui.model.entities.ObservableAsteroid
import com.github.mihowjingle.cartographer.ui.model.entities.ObservablePebble
import com.github.mihowjingle.cartographer.ui.model.entities.ObservableStartingPosition
import com.github.mihowjingle.cartographer.ui.model.level.ObservableLevel
import javafx.beans.property.SimpleBooleanProperty
import javafx.stage.FileChooser
import tornadofx.Controller
import tornadofx.FileChooserMode
import tornadofx.chooseFile
import kotlin.math.min

class ApplicationController : Controller() {

    val startingPositionsValid = SimpleBooleanProperty()
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
                    add(ObservableStartingPosition(size, ObservablePosition()))
                }
            }
            recheckStartingPositionsValid()
        }
    }

    fun remove(startingPosition: ObservableStartingPosition) {
        with(currentLevel) {
            if (startingPositions.size <= 2) {
                error("Cannot remove any more players, 2 is the minimum! (button should be grey, please, report a bug)")
            }
            startingPositions.remove(startingPosition)
            for (i in startingPositions.indices) {
                startingPositions[i].playerIndex = i
            }
            maxPlayers = startingPositions.size
            recheckStartingPositionsValid()
        }
    }

    fun recheckStartingPositionsValid() { // todo maybe move all the "valid" properties here like this one?
        startingPositionsValid.set(valid(currentLevel.startingPositions))
    }
}