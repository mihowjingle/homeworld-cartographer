package com.github.mihowjingle.cartographer.model.level

import com.github.mihowjingle.cartographer.model.common.Color
import com.github.mihowjingle.cartographer.model.common.IntConstraint
import com.github.mihowjingle.cartographer.model.common.Volume

data class Level(
    val author: String,
    val background: Background,
    val maxPlayers: Int,
    val volume: Volume, // todo like... both ways, or only one from center? (diameter vs radius)
    val sensorsManagerCameraDistances: IntConstraint,
    val defaultMusic: Music,
    val battleMusic: Music,
    val fog: Fog,
    val shadowColor: Color, // todo ?? only even seen 0.000000, 0.000000, 0.000000, 1.0 and sometimes even not at all in file
    val glareIntensity: Number // todo ?? only ever seen 0.000000 and sometimes even not at all in file
) {
    init {
        if (maxPlayers !in 2..8) { // actually maybe 1 player too? but would that be interesting anyway?
            throw IllegalArgumentException("Invalid number of players, $maxPlayers! 2..8 allowed.")
        }
    }
}