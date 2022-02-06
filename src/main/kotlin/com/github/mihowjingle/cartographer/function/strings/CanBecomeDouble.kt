package com.github.mihowjingle.cartographer.function.strings

/**
 * Returns true when and only when [this] String is a valid candidate for a Double value.
 * Which is why, for example, "-" results in true (if [allowNegative] is true), because it can still be -1, -0.00089 or whatever,
 * even though "-" is not a valid Double value itself.
 * For the same reason, empty String is also ok - empty string can become any string after some keystrokes. Etc.
 */
fun String.canBecomeDouble(allowNegative: Boolean): Boolean {

    if (this == "") {
        return true
    }

    if (allowNegative && this == "-") {
        return true
    }

    if (!allowNegative && startsWith('-')) {
        return false
    }

    if (this.any { char -> char.isLetter() }) {
        return false
    }

    return try {
        this.toDouble()
        true
    } catch (_ : NumberFormatException) {
        false
    }
}