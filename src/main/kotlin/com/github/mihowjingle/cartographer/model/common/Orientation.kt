package com.github.mihowjingle.cartographer.model.common

/**
 * Orientation in degrees (can be negative, and probably any value, it will just be the same as itself +/- 360)
 * Z axis = vertical axis
 */
data class Orientation(val xAxis: Double, val zAxis: Double, val yAxis: Double)