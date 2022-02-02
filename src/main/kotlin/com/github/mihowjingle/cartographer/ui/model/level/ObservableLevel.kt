package com.github.mihowjingle.cartographer.ui.model.level

import com.github.mihowjingle.cartographer.model.common.Color
import com.github.mihowjingle.cartographer.model.dictionaries.Background
import com.github.mihowjingle.cartographer.model.dictionaries.FogType
import com.github.mihowjingle.cartographer.model.dictionaries.Music
import com.github.mihowjingle.cartographer.model.entities.*
import com.github.mihowjingle.cartographer.model.level.Fog
import com.github.mihowjingle.cartographer.ui.model.common.ObservableConstraint
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import tornadofx.getValue
import tornadofx.observableListOf
import tornadofx.setValue

class ObservableLevel(
    author: String? = null,
    name: String? = null,
    maxPlayers: Int = 2,
    background: Background? = null,
    defaultMusic: Music? = null,
    battleMusic: Music? = null,
    val size: ObservableSize = ObservableSize(), // todo
    val sensorsManagerCameraDistances: ObservableConstraint<Double> = ObservableConstraint(0.0, 0.0), // todo
    val fog: Fog = Fog( // todo
        active = false,
        type = FogType.LINEAR,
        start = 0.0,
        end = 0.0,
        color = Color(255, 255, 255, 255),
        density = 0.0
    ),
    val pebbles: ObservableList<Pebble> = observableListOf(),
    val asteroids: ObservableList<Asteroid> = observableListOf(),
    val startingPositions: ObservableList<StartingPosition> = observableListOf(),
    val clouds: ObservableList<Cloud> = observableListOf(),
    val dustClouds: ObservableList<DustCloud> = observableListOf(),
    val nebulae: ObservableList<Nebula> = observableListOf(),
    val salvage: ObservableList<Salvage> = observableListOf(),
    val megaliths: ObservableList<Megalith> = observableListOf(),
) {
//    init {
//        if (maxPlayers !in 2..8) { // actually maybe 1 player too? but would that be interesting anyway?
//            throw IllegalArgumentException("Invalid number of players, $maxPlayers! 2..8 allowed.")
//        }
//    }

    val authorProperty = SimpleStringProperty(author)
    var author: String? by authorProperty

    val nameProperty = SimpleStringProperty(name)
    var name: String? by nameProperty

    val maxPlayersProperty = SimpleIntegerProperty(maxPlayers)
    var maxPlayers: Int by maxPlayersProperty

    val backgroundProperty = SimpleObjectProperty(background)
    var background: Background? by backgroundProperty

    val defaultMusicProperty = SimpleObjectProperty(defaultMusic)
    var defaultMusic: Music? by defaultMusicProperty

    val battleMusicProperty = SimpleObjectProperty(battleMusic)
    var battleMusic: Music? by battleMusicProperty

    //

    override fun toString(): String {
        return "ObservableLevel(author=$author, name=$name, background=$background, maxPlayers=$maxPlayers, defaultMusic=$defaultMusic, battleMusic=$battleMusic, size=$size, sensorsManagerCameraDistances=$sensorsManagerCameraDistances, fog=$fog, pebbles=$pebbles, asteroids=$asteroids, startingPositions=$startingPositions, clouds=$clouds, dustClouds=$dustClouds, nebulae=$nebulae, salvage=$salvage, megaliths=$megaliths)"
    }
}