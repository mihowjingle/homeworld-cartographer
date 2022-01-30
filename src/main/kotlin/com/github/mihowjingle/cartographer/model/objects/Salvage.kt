package com.github.mihowjingle.cartographer.model.objects

import com.github.mihowjingle.cartographer.model.common.Position

const val defaultSalvageRus = 700

// todo, for salvage and asteroids, introduce constructor with desired effective RUs and then calculate what % it should be
data class Salvage(val type: Type, val position: Position, val percentOfDefaultRus: Int) : Entity {
    enum class Type(val label: String) {
        SALVAGE_SMALL_01("Slv_Chunk_Sml01"),
        SALVAGE_SMALL_02("Slv_Chunk_Sml02"),
        SALVAGE_SMALL_03("Slv_Chunk_Sml03"),
        SALVAGE_SMALL_04("Slv_Chunk_Sml04"),
        SALVAGE_SMALL_05("Slv_Chunk_Sml05"),
        SALVAGE_SMALL_06("Slv_Chunk_Sml06"),
        SALVAGE_SMALL_07("Slv_Chunk_Sml07"),
        SALVAGE_SMALL_08("Slv_Chunk_Sml08"),
        SALVAGE_LARGE_01("Slv_Chunk_Lrg01"),
        SALVAGE_LARGE_02("Slv_Chunk_Lrg02"),
        SALVAGE_LARGE_03("Slv_Chunk_Lrg03"),
        SALVAGE_LARGE_04("Slv_Chunk_Lrg04"),
        SALVAGE_LARGE_05("Slv_Chunk_Lrg05")
    }

    val effectiveRus = percentOfDefaultRus * defaultSalvageRus / 100

    // todo last 4 numbers? rotation probably...? and size?
    override fun toLua() = "addSalvage(\"${type.label}\", {${position.x}, ${position.z}, ${position.y}}, $percentOfDefaultRus, 0, 0, 0, 0)"
}
