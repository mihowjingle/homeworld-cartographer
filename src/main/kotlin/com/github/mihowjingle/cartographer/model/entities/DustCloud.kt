package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Color
import com.github.mihowjingle.cartographer.model.common.Position

data class DustCloud(
    val name: String,
    val type: Type,
    val position: Position,
    val color: Color,
    val initialRotationDegrees: Double, // probably
    val size: Double
) : LevelEntity {
    enum class Type(val label: String) {
        DC_0("DustCloud_0"),
        DC_NO_RES("DustCloud_NoRes"),
        DC_NO_RES_M05("DustCloud_NoRes_M05"),
        DC_NO_RES2("DustCloud_NoRes2"),
        DC_NO_RES2_M05("DustCloud_NoRes2_M05"),
        DC_NO_RES3("DustCloud_NoRes3"),
        DC_NO_RES3_M05("DustCloud_NoRes3_M05"),
        DC_NO_RES_NO_CHARGE("DustCloud_NoRes_NoCharge"),
        DC_TEAL("DustCloud_Teal")
    }

    override fun toLua() =
        "addDustCloud(\"$name\",\"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, {${color.r}, ${color.g}, ${color.b}, ${color.a}}, $initialRotationDegrees, $size)"
}
