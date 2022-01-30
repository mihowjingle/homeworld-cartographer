package com.github.mihowjingle.cartographer.model.objects

import com.github.mihowjingle.cartographer.model.common.Orientation
import com.github.mihowjingle.cartographer.model.common.Position

/**
 * Player index can be 0..7
 */
data class StartingPosition(val playerIndex: Int, val position: Position, val orientation: Orientation) : Entity {

    init {
        if (playerIndex !in 0..7) {
            throw IllegalArgumentException("Invalid play index $playerIndex! 0..7 allowed.")
        }
    }

    override fun toLua() =
        "addPoint(\"StartPos$playerIndex\", {${position.x}, ${position.z}, ${position.y}}, {${orientation.xAxis}, ${orientation.zAxis}, ${orientation.yAxis}})"
}