package com.github.mihowjingle.cartographer.model.level

import com.github.mihowjingle.cartographer.model.common.Color
import com.github.mihowjingle.cartographer.model.common.Constraint
import com.github.mihowjingle.cartographer.model.common.Volume
import com.github.mihowjingle.cartographer.model.objects.*

data class Level(
    val author: String,
    val background: Background,
    val maxPlayers: Int,
    val volume: Volume,
    val sensorsManagerCameraDistances: Constraint<Double>,
    val defaultMusic: Music,
    val battleMusic: Music,
    val fog: Fog,

    // map objects... level entities... something
    val pebbles: List<Pebble>,
    val asteroids: List<Asteroid>,
    val startingPositions: List<StartingPosition>,
    val clouds: List<Cloud>,
    val dustClouds: List<DustCloud>,
    val nebulae: List<Nebula>,
    val salvage: List<Salvage>,
    val megaliths: List<Megalith>,

    // ?? only even seen 0.000000, 0.000000, 0.000000, 1.0 and sometimes even not at all in file,
    // after brief testing, no apparent change
    val shadowColor: Color = Color(0, 0, 0, 255),

    // ?? only ever seen 0.000000 and sometimes even not at all in file,
    // after brief testing, no apparent change
    val glareIntensity: Double = 0.0
) {
    init {
        if (maxPlayers !in 2..8) { // actually maybe 1 player too? but would that be interesting anyway?
            throw IllegalArgumentException("Invalid number of players, $maxPlayers! 2..8 allowed.")
        }
    }
}