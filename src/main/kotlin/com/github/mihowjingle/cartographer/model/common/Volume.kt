package com.github.mihowjingle.cartographer.model.common
/**
 * Yes, this basically [Position], but... names matter (tm)
 * The numbers are like radius rather than diameter, for example z of 60_000 means 120_000 total height.
 * 60km above and 60km below the sensor manager plane
 */
// todo which is width, which is depth? also would be nice to relate to the 0, 90, 180, 270 markers
data class Volume(val x: Double, val z: Double, val y: Double)