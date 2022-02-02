package com.github.mihowjingle.cartographer.ui.model.common

class ObservableConstraint<T : Comparable<T>>(min: T, max: T) {

    init {
        if (min > max) {
            throw IllegalArgumentException("min ($min) > max ($max)")
        }
    }

    var min = min
        set(value) {
            if (value > max) {
                throw IllegalArgumentException("min ($value) > max ($max)")
            }
            field = value
        }

    var max = max
        set(value) {
            if (min > value) {
                throw IllegalArgumentException("min ($min) > max ($value)")
            }
            field = value
        }

    override fun toString(): String {
        return "ObservableConstraint(min=$min, max=$max)"
    }
}