package com.github.mihowjingle.cartographer.model.common

import kotlin.random.Random

/**
 * Rotation in degrees (can be negative), z axis = vertical axis
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