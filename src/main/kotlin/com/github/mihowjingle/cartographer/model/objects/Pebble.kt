package com.github.mihowjingle.cartographer.model.objects

import com.github.mihowjingle.cartographer.model.common.Position

/**
 * "Pebble_3" crashes the game, allegedly
 */
data class Pebble(val type: Type, val position: Position) : Entity {
    enum class Type(val label: String) {
        PEBBLE_0("Pebble_0"),
        PEBBLE_1("Pebble_1"),
        PEBBLE_2("Pebble_2")
    }

    val label by type::label
    val x by position::x
    val z by position::z
    val y by position::y

    // todo last 3 numbers...? rotation?
    override fun toLua() = "addPebble(\"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, 0.0, 0.0, 0.0)"
}