package com.github.mihowjingle.cartographer.model.common

/**
 * In some references it's actually x,z,y ... probably best would be x, y, height, or something, to avoid ambiguity
 *
 * todo test which parameter does what, in-game
 */
data class Position(val x: Double, val y: Double, val z: Double)