package com.github.mihowjingle.cartographer.model.level

import com.github.mihowjingle.cartographer.model.common.Color
import com.github.mihowjingle.cartographer.model.dictionaries.FogType

data class Fog(val active: Boolean, val type: FogType?, val start: Double?, val end: Double?, val color: Color?, val density: Double?)