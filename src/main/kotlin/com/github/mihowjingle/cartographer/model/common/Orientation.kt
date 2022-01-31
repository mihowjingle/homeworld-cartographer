package com.github.mihowjingle.cartographer.model.common

import kotlin.random.Random

/**
 * Orientation in degrees (can be negative, and probably any value, it will just be the same as itself +/- 360)
 * Z axis = vertical axis
 */
data class Orientation(val xAxis: Double, val zAxis: Double, val yAxis: Double) {
    companion object {
        fun random(): Orientation {
            val x = Random.nextDouble(360.0)
            val z = Random.nextDouble(360.0)
            val y = Random.nextDouble(360.0)
            return Orientation(x, z ,y)
        }
    }
}