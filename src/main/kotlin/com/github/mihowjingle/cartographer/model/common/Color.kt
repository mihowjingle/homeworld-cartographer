package com.github.mihowjingle.cartographer.model.common

// looks like 0..255 is too logical
// javafx's Color is 0.0..1.0 too, todo adapt or resign from this completely
data class Color(val red: Int, val green: Int, val blue: Int, val alpha: Int) {

    /**
     * red, but 0.0 - 1.0, not 0 - 255
     */
    val r = red.toDouble() / 255

    /**
     * green, but 0.0 - 1.0, not 0 - 255
     */
    val g = green.toDouble() / 255

    /**
     * blue, but 0.0 - 1.0, not 0 - 255
     */
    val b = blue.toDouble() / 255

    /**
     * alpha, but 0.0 - 1.0, not 0 - 255
     */
    val a = alpha.toDouble() / 255

    init {
        if (arrayOf(red, green, blue, alpha).any { it > 255 || it < 0 }) {
            throw IllegalArgumentException("RGBA value outside of 0..255! ($red, $green, $blue, $alpha)")
        }
    }
}