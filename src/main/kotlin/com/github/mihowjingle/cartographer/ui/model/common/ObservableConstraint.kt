package com.github.mihowjingle.cartographer.ui.model.common

class ObservableConstraint<T : Comparable<T>>(min: T, max: T) {

    var min = min
        set(value) {
            if (min > max) {
                throw IllegalArgumentException("min ($min) > max ($max)")
            }
            field = value
        }

    var max = max
        set(value) {
            if (min > max) {
                throw IllegalArgumentException("min ($min) > max ($max)")
            }
            field = value
        }
}