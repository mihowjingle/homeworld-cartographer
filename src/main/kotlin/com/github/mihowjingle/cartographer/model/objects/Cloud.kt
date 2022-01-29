package com.github.mihowjingle.cartographer.model.objects

import com.github.mihowjingle.cartographer.model.common.Color
import com.github.mihowjingle.cartographer.model.common.Position

data class Cloud(
    val name: String,
    val type: Type,
    val position: Position,
    val color: Color,
    val initialRotationDegrees: Double, // probably
    val size: Double
) : Entity {
    enum class Type(val label: String) {
        DC_0("Cloud_0"),
        DC_NO_RES("Cloud_NoRes"),
        DC_NO_RES2("Cloud_NoRes2"),
        DC_NO_RES3("Cloud_NoRes3")
    }

    override fun toLua() =
        "addCloud(\"$name\",\"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, {${color.r}, ${color.g}, ${color.b}, ${color.a}}, $initialRotationDegrees, $size)"
}
