package com.github.mihowjingle.cartographer.model.level

import com.github.mihowjingle.cartographer.model.common.Color

// todo what about fog type? I've only ever seen 'linear'
data class Fog(val active: Boolean, val start: Double, val end: Double, val color: Color, val density: Double) {

    // doesn't matter, its fogSetActive(0) and nothing else
    // todo probably won't be needed as i'm probably making this mutable with default params
    constructor() : this(false, 0.0, 0.0, Color(0, 0, 0, 0), 0.0)
}