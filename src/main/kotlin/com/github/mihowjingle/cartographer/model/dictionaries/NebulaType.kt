package com.github.mihowjingle.cartographer.model.dictionaries

enum class NebulaType(override val label: String) : Dictionary {
    NEBULA_M07_FOUNDRY_RADIATION("M07_Foundry_Radiation"), // a bit ugly but ok (weird reaction to light)
    NEBULA_M08_NO_DAMAGE_RADIATION("M08_NoDamage_Radiation"), // a bit ugly but ok (weird reaction to light)
    NEBULA_M11_BENTUSI_DEBRIS("M11_Bentusi_Debris"), // ok
    NEBULA_M11_BENTUSI_RADIATION("M11_Bentusi_Radiation"), // ok
    NEBULA_MP_BENTUSI_RADIATION("MP_Bentusi_Radiation"), // nice! recommended
    NEBULA_01_CREAM("Nebula01_Cream"), // a bit ugly but ok (weird reaction to light)
    NEBULA_01_TEAL("Nebula01_Teal"), // a bit ugly but ok (weird reaction to light)
    NEBULA_0("Nebula_0"), // ok
    NEBULA_RADIATION("Radiation") // a bit ugly but ok (weird reaction to light)
}