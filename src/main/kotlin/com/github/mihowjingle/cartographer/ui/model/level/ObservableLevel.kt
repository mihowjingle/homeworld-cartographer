package com.github.mihowjingle.cartographer.ui.model.level

import com.github.mihowjingle.cartographer.model.entities.*
import com.github.mihowjingle.cartographer.model.level.Level
import com.github.mihowjingle.cartographer.ui.model.entities.ObservablePebble
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import tornadofx.getValue
import tornadofx.observableListOf
import tornadofx.setValue

/**
 * UI version of [Level]
 */
class ObservableLevel(
    author: String? = null,
    name: String? = null,
    maxPlayers: Int = 2,
    background: String? = null,
    defaultMusic: String? = null,
    battleMusic: String? = null,
    val size: ObservableSize = ObservableSize(),
    val sensorsManagerCameraDistances: ObservableSMCD = ObservableSMCD(),
    val fog: ObservableFog = ObservableFog(),
    val pebbles: ObservableList<ObservablePebble> = observableListOf(),
    val asteroids: ObservableList<Asteroid> = observableListOf(),
    val startingPositions: ObservableList<StartingPosition> = observableListOf(),
    val clouds: ObservableList<Cloud> = observableListOf(),
    val dustClouds: ObservableList<DustCloud> = observableListOf(),
    val nebulae: ObservableList<Nebula> = observableListOf(),
    val salvage: ObservableList<Salvage> = observableListOf(),
    val megaliths: ObservableList<Megalith> = observableListOf()
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

    val backgroundProperty = SimpleStringProperty(background)
    var background: String? by backgroundProperty

    val defaultMusicProperty = SimpleStringProperty(defaultMusic)
    var defaultMusic: String? by defaultMusicProperty

    val battleMusicProperty = SimpleStringProperty(battleMusic)
    var battleMusic: String? by battleMusicProperty

    override fun toString(): String {
        return "ObservableLevel(author=$author, name=$name, background=$background, maxPlayers=$maxPlayers, defaultMusic=$defaultMusic, battleMusic=$battleMusic, size=$size, sensorsManagerCameraDistances=$sensorsManagerCameraDistances, fog=$fog, pebbles=$pebbles, asteroids=$asteroids, startingPositions=$startingPositions, clouds=$clouds, dustClouds=$dustClouds, nebulae=$nebulae, salvage=$salvage, megaliths=$megaliths)"
    }

    /**
     * !!! only top-level info, not [size], [fog], etc
     */
    val infoValid: Boolean get() {
        return name != null && background != null && defaultMusic != null && battleMusic != null
    }
}