package com.github.mihowjingle.cartographer.model.level

import com.github.mihowjingle.cartographer.model.common.Color

data class Fog(val active: Boolean, val type: Type, val start: Double, val end: Double, val color: Color, val density: Double) {
    enum class Type(val label: String) {
        FOG_LINEAR("linear"),
        FOG_EXP("exp"),
        FOG_EXP2("exp2")
    }

    // other params don't matter, it's fogSetActive(0) in the file, and nothing else
    // todo probably won't be needed as i'm probably making this mutable with default params
    constructor() : this(false, Type.FOG_LINEAR, 0.0, 0.0, Color(0, 0, 0, 0), 0.0)
}