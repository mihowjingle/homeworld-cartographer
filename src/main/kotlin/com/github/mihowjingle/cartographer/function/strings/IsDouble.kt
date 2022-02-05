package com.github.mihowjingle.cartographer.function.strings

fun String?.isDouble(): Boolean {
    if (this == null) {
        return false
    }
    return try {
        this.toDouble()
        true
    } catch (_: NumberFormatException) {
        false
    }
}