package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Orientation
import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.dictionaries.AsteroidType

/**
 * [initialOrientation] doesn't matter that much, after like 30 seconds asteroids are all randomized anyway, because they spin randomly
 */
data class Asteroid(
    val type: AsteroidType,
    val position: Position,
    val percentOfDefaultRus: Double,
    val initialOrientation: Orientation
) : LevelEntity {

    val effectiveRus = percentOfDefaultRus * type.defaultRus / 100

    override fun toLua() = "addAsteroid(\"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, $percentOfDefaultRus, " +
            "${initialOrientation.xAxis}, ${initialOrientation.zAxis}, ${initialOrientation.yAxis}, 0)" // last number - no apparent effect
}