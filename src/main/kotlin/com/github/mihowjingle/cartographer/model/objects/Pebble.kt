package com.github.mihowjingle.cartographer.model.objects

import com.github.mihowjingle.cartographer.model.common.Position

/**
 * "Pebble_3" crashes the game, allegedly
 */
data class Pebble(val type: Type, val position: Position) {
    enum class Type(val label: String) {
        PEBBLE_0("Pebble_0"),
        PEBBLE_1("Pebble_1"),
        PEBBLE_2("Pebble_2")
    }

    // todo last 3 numbers...? rotation?
    fun toLua() = "addPebble(\"${type.label}\", {${position.x}, ${position.y}, ${position.z}}, 0.0, 0.0, 0.0)"
}