package com.github.mihowjingle.cartographer.model.objects

import com.github.mihowjingle.cartographer.model.common.Color
import com.github.mihowjingle.cartographer.model.common.Position

data class Nebula(
    val name: String,
    val type: Type,
    val position: Position,
    val color: Color,
    val initialRotationDegrees: Double, // probably
    val size: Double
) : Entity {
    enum class Type(val label: String) {
        NEBULA_M05_DC_NEBULA("M05_DustCloud_Nebula"),
        NEBULA_M05_BC_NO_RES("M05_NebualDustCloud_NoRes"), // Nebual? todo after brief research: yes, but seems to be deprecated, test
        NEBULA_M05_DC_NO_RES2("M05_NebualDustCloud_NoRes2"),
        NEBULA_M05_DC_NO_RES3("M05_NebualDustCloud_NoRes3"),
        NEBULA_M07_FOUNDRY_RADIATION("M07_Foundry_Radiation"),
        NEBULA_M08_NO_DAMAGE_RADIATION("M08_NoDamage_Radiation"),
        NEBULA_M11_BENTUSI_DEBRIS("M11_Bentusi_Debris"),
        NEBULA_M11_BENTUSI_RADIATION("M11_Bentusi_Radiation"),
        NEBULA_MP_BENTUSI_RADIATION("MP_Bentusi_Radiation"),
        NEBULA_01_CREAM("Nebula01_Cream"),
        NEBULA_01_TEAL("Nebula01_Teal"),
        NEBULA_0("Nebula_0"),
        NEBULA_HIDING("Nebula_Hiding"),
        NEBULA_RADIATION("Radiation")
    }

    override fun toLua() = "addNebula(\"$name\", \"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, " +
            "{${color.r}, ${color.g}, ${color.b}, ${color.a}}, $initialRotationDegrees, $size)"
}
