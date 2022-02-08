package com.github.mihowjingle.cartographer.model.level

import com.github.mihowjingle.cartographer.model.dictionaries.Background
import com.github.mihowjingle.cartographer.model.dictionaries.Music
import com.github.mihowjingle.cartographer.model.entities.*

data class Level(
    val author: String?, // i mean... shouldn't you be proud of your creation? but ok
    val name: String,
    val background: Background,
    val maxPlayers: Int,
    val size: Size,
    val sensorsManagerCameraDistances: SensorManagerCameraDistances,
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
        if (maxPlayers !in 2..8) {
            throw IllegalArgumentException("Invalid number of players, $maxPlayers! 2..8 allowed.")
        }
    }
}