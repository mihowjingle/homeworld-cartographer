package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Color
import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.dictionaries.NebulaType

data class Nebula(
    val name: String,
    val type: NebulaType,
    val position: Position,
    val color: Color,
    val initialRotationDegrees: Double, // probably
    val size: Double
) : LevelEntity {

    override fun toLua() = "addNebula(\"$name\", \"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, " +
            "{${color.r}, ${color.g}, ${color.b}, ${color.a}}, $initialRotationDegrees, $size)"
}