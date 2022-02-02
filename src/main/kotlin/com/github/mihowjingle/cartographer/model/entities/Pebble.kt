package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType

/**
 * "Pebble_3" crashes the game, allegedly.
 * After some investigation, last 3 numbers (in .level file) DO NOT seem to represent orientation. But what?
 */
data class Pebble(val type: PebbleType, val position: Position) : LevelEntity {

    val label by type::label
    val x by position::x
    val z by position::z
    val y by position::y

    override fun toLua() = "addPebble(\"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, 0.0, 0.0, 0.0)"
}