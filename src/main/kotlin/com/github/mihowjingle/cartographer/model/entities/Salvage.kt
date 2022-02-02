package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.dictionaries.SalvageType

// todo, for salvage and asteroids, introduce constructor (or setter, i'm probably making these mutable)
//  with desired effective RUs and then calculate what % it should be
data class Salvage(val type: SalvageType, val position: Position, val percentOfDefaultRus: Double) : LevelEntity {


    /**
     * Default RUs per salvage is 700 (for all types)
     */
    val effectiveRus = percentOfDefaultRus * 7

    /**
     * After some investigation, the last 4 numbers DO NOT seem to be orientation or size.
     */
    override fun toLua() = "addSalvage(\"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, $percentOfDefaultRus, 0, 0, 0, 0)"
}
