package com.github.mihowjingle.cartographer.model.common

data class IntConstraint(val min: Int, val max: Int) {
    init {
        if (min > max) {
            throw IllegalArgumentException("min ($min) > max ($max)")
        }
    }
}