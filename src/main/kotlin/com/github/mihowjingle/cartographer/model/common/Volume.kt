package com.github.mihowjingle.cartographer.model.common
/**
 * Yes, this basically [Position], but... names matter (tm)
 * z = height!
 */
// todo which is width, which is depth? also would be nice to relate to the 0, 90, 180, 270 markers
data class Volume(val x: Number, val z: Number, val y: Number)