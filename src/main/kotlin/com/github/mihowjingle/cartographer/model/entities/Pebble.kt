package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Position

/**
 * "Pebble_3" crashes the game, allegedly.
 * After some investigation, last 3 numbers (in .level file) DO NOT seem to represent orientation. But what?
 */
data class Pebble(val type: Type, val position: Position) : LevelEntity {
    enum class Type(val label: String) {
        PEBBLE_0("Pebble_0"),
        PEBBLE_1("Pebble_1"),
        PEBBLE_2("Pebble_2")
    }

    val label by type::label
    val x by position::x
    val z by position::z
    val y by position::y

    override fun toLua() = "addPebble(\"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, 0.0, 0.0, 0.0)"
}