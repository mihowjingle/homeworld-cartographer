package com.github.mihowjingle.cartographer.model.level

import com.github.mihowjingle.cartographer.model.common.Constraint
import com.github.mihowjingle.cartographer.model.entities.*

data class Level(
    val author: String?, // i mean... shouldn't you be proud of your creation? but ok
    val background: Background,
    val maxPlayers: Int,
    val size: Size,
    val sensorsManagerCameraDistances: Constraint<Double>,
    val defaultMusic: Music,
    val battleMusic: Music,
    val fog: Fog,
    val pebbles: List<Pebble>,
    val asteroids: List<Asteroid>,
    val startingPositions: List<StartingPosition>,
    val clouds: List<Cloud>,
    val dustClouds: List<DustCloud>,
    val nebulae: List<Nebula>,
    val salvage: List<Salvage>,
    val megaliths: List<Megalith>
) {
    init {
        if (maxPlayers !in 2..8) { // actually maybe 1 player too? but would that be interesting anyway?
            throw IllegalArgumentException("Invalid number of players, $maxPlayers! 2..8 allowed.")
        }
    }
}