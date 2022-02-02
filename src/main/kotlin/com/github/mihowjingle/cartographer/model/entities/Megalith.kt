package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Orientation
import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.dictionaries.MegalithType

data class Megalith(
    val name: String,
    val type: MegalithType,
    val position: Position,
    val ownerPlayerIndex: Int = -1, // -1 is no owner
    val orientation: Orientation
) : LevelEntity {

    override fun toLua(): String {
        return "addSquadron(\"$name\", \"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, $ownerPlayerIndex, " +
                "{${orientation.xAxis}, ${orientation.zAxis}, ${orientation.yAxis}}, 0, 0)"
    }
}