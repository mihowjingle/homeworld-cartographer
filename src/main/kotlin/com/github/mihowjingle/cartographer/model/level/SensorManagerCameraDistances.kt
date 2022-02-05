package com.github.mihowjingle.cartographer.model.level

data class SensorManagerCameraDistances(val min: Double, val max: Double) {
    init {
        if (min > max || min <= 0.0 || max <= 0.0) {
            throw IllegalArgumentException("min ($min) > max ($max), or at least one of them <= 0")
        }
    }
}