package com.github.mihowjingle.cartographer.model.level
/**
 * The numbers are like radius rather than diameter, for example z of 60000 means 120000 total height.
 * 60km above and 60km below the sensor manager plane.
 *
 * x values change between 90 <-> 270 markers
 * y values change between 0 <-> 180 markers
 *
 * so
 *
 * x = 0 line goes between 0 <-> 180 markers
 * y = 0 line goes between 90 <-> 270 markers
 */
data class Size(val x: Double, val z: Double, val y: Double)