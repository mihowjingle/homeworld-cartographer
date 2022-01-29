package com.github.mihowjingle.cartographer.model.objects

import com.github.mihowjingle.cartographer.model.common.Position

data class Salvage(val type: Type, val position: Position, val percentOfDefaultRus: Int) : Entity {
    enum class Type(val label: String, val defaultRus: Int) {
        SALVAGE_SMALL_01("Slv_Chunk_Sml01", 0), // todo investigate defaultRus
        SALVAGE_SMALL_02("Slv_Chunk_Sml02", 0),
        SALVAGE_SMALL_03("Slv_Chunk_Sml03", 0),
        SALVAGE_SMALL_04("Slv_Chunk_Sml04", 0),
        SALVAGE_SMALL_05("Slv_Chunk_Sml05", 0),
        SALVAGE_SMALL_06("Slv_Chunk_Sml06", 0),
        SALVAGE_SMALL_07("Slv_Chunk_Sml07", 0),
        SALVAGE_SMALL_08("Slv_Chunk_Sml08", 0),
        SALVAGE_LARGE_01("Slv_Chunk_Lrg01", 0),
        SALVAGE_LARGE_02("Slv_Chunk_Lrg02", 0),
        SALVAGE_LARGE_03("Slv_Chunk_Lrg03", 0),
        SALVAGE_LARGE_04("Slv_Chunk_Lrg04", 0),
        SALVAGE_LARGE_05("Slv_Chunk_Lrg05", 0)
    }

    val effectiveRus = percentOfDefaultRus * type.defaultRus / 100

    // todo last 4 numbers? rotation probably...? and size?
    override fun toLua() = "addSalvage(\"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, $percentOfDefaultRus, 0, 0, 0, 0)"
}
