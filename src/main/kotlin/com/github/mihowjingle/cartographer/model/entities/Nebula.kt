package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Color
import com.github.mihowjingle.cartographer.model.common.Position

data class Nebula(
    val name: String,
    val type: Type,
    val position: Position,
    val color: Color,
    val initialRotationDegrees: Double, // probably
    val size: Double
) : LevelEntity {
    enum class Type(val label: String) {
        NEBULA_M07_FOUNDRY_RADIATION("M07_Foundry_Radiation"), // a bit ugly but ok (weird reaction to light)
        NEBULA_M08_NO_DAMAGE_RADIATION("M08_NoDamage_Radiation"), // a bit ugly but ok (weird reaction to light)
        NEBULA_M11_BENTUSI_DEBRIS("M11_Bentusi_Debris"), // ok
        NEBULA_M11_BENTUSI_RADIATION("M11_Bentusi_Radiation"), // ok
        NEBULA_MP_BENTUSI_RADIATION("MP_Bentusi_Radiation"), // nice! recommended
        NEBULA_01_CREAM("Nebula01_Cream"), // a bit ugly but ok (weird reaction to light)
        NEBULA_01_TEAL("Nebula01_Teal"), // a bit ugly but ok (weird reaction to light)
        NEBULA_0("Nebula_0"), // ok
        NEBULA_RADIATION("Radiation") // a bit ugly but ok (weird reaction to light)
    }

    override fun toLua() = "addNebula(\"$name\", \"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, " +
            "{${color.r}, ${color.g}, ${color.b}, ${color.a}}, $initialRotationDegrees, $size)"
}