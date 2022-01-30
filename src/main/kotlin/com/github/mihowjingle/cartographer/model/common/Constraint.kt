package com.github.mihowjingle.cartographer.model.common

data class Constraint<T : Comparable<T>>(val min: T, val max: T) {
    init {
        if (min > max) {
            throw IllegalArgumentException("min ($min) > max ($max)")
        }
    }
}