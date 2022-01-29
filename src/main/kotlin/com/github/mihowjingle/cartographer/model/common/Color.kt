package com.github.mihowjingle.cartographer.model.common

data class Color(val red: Int, val green: Int, val blue: Int, val alpha: Int) {
    val r = red.toDouble() / 255
    val g = green.toDouble() / 255
    val b = blue.toDouble() / 255
    val a = alpha.toDouble() / 255

    init {
        // todo throw if >0 or 255<
        // todo should i test such stuff?
    }

    fun toLua(): String { // todo needed?
        return "$r, $g, $b, $a"
    }
}