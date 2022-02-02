package com.github.mihowjingle.cartographer.model.common

/**
 * An object whose purpose is to ensure that min <= max.
 * Also, nice for grouping properties of another object thematically - whatever it is,
 * [min] and [max] are the minimum and maximum of the same thing.
 */
data class Constraint<T : Comparable<T>>(val min: T, val max: T) {
    init {
        if (min > max) {
            throw IllegalArgumentException("min ($min) > max ($max)")
        }
    }
}