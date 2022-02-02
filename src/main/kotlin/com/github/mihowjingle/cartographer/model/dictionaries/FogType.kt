package com.github.mihowjingle.cartographer.model.dictionaries

enum class FogType(override val label: String) : Dictionary {
    LINEAR("linear"),
    EXP("exp"),
    EXP2("exp2")
}