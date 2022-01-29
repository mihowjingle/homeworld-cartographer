package com.github.mihowjingle.cartographer.model.objects

import com.github.mihowjingle.cartographer.model.common.Position

data class Asteroid(val type: Type, val position: Position, val percentOfDefaultRus: Int) : Entity {
    enum class Type(val label: String, val defaultRus: Int, val maxSupportedCollectors: Int) {

        // found in existing HW2 maps
        ASTEROID_1(label = "Asteroid_1", defaultRus = 0, maxSupportedCollectors = 0),
        ASTEROID_2(label = "Asteroid_2", defaultRus = 0, maxSupportedCollectors = 0),
        ASTEROID_3(label = "Asteroid_3", defaultRus = 9000, maxSupportedCollectors = 1),
        ASTEROID_4(label = "Asteroid_4", defaultRus = 18000, maxSupportedCollectors = 2),
        ASTEROID_5(label = "Asteroid_5", defaultRus = 40000, maxSupportedCollectors = 3),

        // found in existing HW1 maps TODO! research maxSupportedCollectors, 1 is just a placeholder
        ASTEROID_1_MP(label = "Asteroid1_MP", defaultRus = 2400, maxSupportedCollectors = 1),
        ASTEROID_2_MP(label = "Asteroid2_MP", defaultRus = 3600, maxSupportedCollectors = 1),
        ASTEROID_3_MP(label = "Asteroid3_MP", defaultRus = 4800, maxSupportedCollectors = 1),
        ASTEROID_4_MP(label = "Asteroid4_MP", defaultRus = 6000, maxSupportedCollectors = 1);

        // todo probably more, trial-error test in-game and research resources etc.

        val harvestable = defaultRus > 0
    }

    val effectiveRus = percentOfDefaultRus * type.defaultRus / 100

    // todo last 4 numbers...?
    override fun toLua() = "addAsteroid(\"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, $percentOfDefaultRus, 0.000, 0.000, 0.000, 0)"
}