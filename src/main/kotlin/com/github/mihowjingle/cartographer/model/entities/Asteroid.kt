package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Orientation
import com.github.mihowjingle.cartographer.model.common.Position

/**
 * [initialOrientation] doesn't matter that much, after like 30 seconds asteroids are all randomized anyway, because they spin randomly
 */
data class Asteroid(
    val type: Type,
    val position: Position,
    val percentOfDefaultRus: Double,
    val initialOrientation: Orientation = Orientation.random()
) : LevelEntity {
    enum class Type(val label: String, val defaultRus: Int, val maxSupportedCollectors: Int) {

        // found in existing HW2 maps
        ASTEROID_1(label = "Asteroid_1", defaultRus = 0, maxSupportedCollectors = 0),
        ASTEROID_2(label = "Asteroid_2", defaultRus = 0, maxSupportedCollectors = 0),
        ASTEROID_3(label = "Asteroid_3", defaultRus = 9000, maxSupportedCollectors = 1),
        ASTEROID_4(label = "Asteroid_4", defaultRus = 18000, maxSupportedCollectors = 2),
        ASTEROID_5(label = "Asteroid_5", defaultRus = 40000, maxSupportedCollectors = 3),

        // found in existing HW1 maps
        ASTEROID0_MP(label = "Asteroid0_MP", defaultRus = 0, maxSupportedCollectors = 0), // supposedly 1200 RUs, but tested in game, can't harvest
        ASTEROID1_MP(label = "Asteroid1_MP", defaultRus = 2400, maxSupportedCollectors = 1),
        ASTEROID2_MP(label = "Asteroid2_MP", defaultRus = 3600, maxSupportedCollectors = 1),
        ASTEROID3_MP(label = "Asteroid3_MP", defaultRus = 4800, maxSupportedCollectors = 2),
        ASTEROID4_MP(label = "Asteroid4_MP", defaultRus = 6000, maxSupportedCollectors = 3),

        // all below found in game files, resources
        ASTEROID_4_PIECE_01(label = "Asteroid_4_piece01", defaultRus = 100, maxSupportedCollectors = 2),
        ASTEROID_4_PIECE_02(label = "Asteroid_4_piece02", defaultRus = 100, maxSupportedCollectors = 2),
        ASTEROID_4_PIECE_03(label = "Asteroid_4_piece03", defaultRus = 100, maxSupportedCollectors = 2),

        // needs to be destroyed first, pieces drift away, not sure about this one
        ASTEROID_5_PIECE_01(label = "Asteroid_5_piece01", defaultRus = 100, maxSupportedCollectors = 4),

        // needs to be destroyed first, pieces drift away, not sure about this one
        ASTEROID_5_PIECE_02(label = "Asteroid_5_piece02", defaultRus = 100, maxSupportedCollectors = 4),

        // needs to be destroyed first, pieces drift away, not sure about this one
        ASTEROID_5_PIECE_03(label = "Asteroid_5_piece03", defaultRus = 60, maxSupportedCollectors = 4),

        // weird - has collision, but no "go-to" command, you can order units to go inside it, which they'll never complete
        ASTEROID_6(label = "Asteroid_6", defaultRus = 0, maxSupportedCollectors = 0),

        ASTEROID0(label = "Asteroid0", defaultRus = 0, maxSupportedCollectors = 0), // supposedly 1200 RUs, but tested in game, can't harvest
        ASTEROID1(label = "Asteroid1", defaultRus = 100, maxSupportedCollectors = 1), // looks ok?
        ASTEROID2(label = "Asteroid2", defaultRus = 100, maxSupportedCollectors = 1), // looks ok?
        ASTEROID3(label = "Asteroid3", defaultRus = 100, maxSupportedCollectors = 2), // looks ok?
        ASTEROID4(label = "Asteroid4", defaultRus = 100, maxSupportedCollectors = 3); // looks ok?

        val harvestable = defaultRus > 0
    }

    val effectiveRus = percentOfDefaultRus * type.defaultRus / 100

    override fun toLua() = "addAsteroid(\"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, $percentOfDefaultRus, " +
            "${initialOrientation.xAxis}, ${initialOrientation.zAxis}, ${initialOrientation.yAxis}, 0)" // last number - no apparent effect
}