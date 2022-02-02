package com.github.mihowjingle.cartographer.model.common

data class Color(val red: Double, val green: Double, val blue: Double, val alpha: Double) {

    init {
        if (arrayOf(red, green, blue, alpha).any { it > 1.0 || it < 0.0 }) {
            throw IllegalArgumentException("RGBA value outside of 0.0 .. 1.0! ($red, $green, $blue, $alpha)")
        }
    }
}