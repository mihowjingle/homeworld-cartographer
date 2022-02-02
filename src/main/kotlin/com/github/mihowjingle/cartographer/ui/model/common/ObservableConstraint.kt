package com.github.mihowjingle.cartographer.ui.model.common

data class ObservableConstraint<T : Comparable<T>>(var min: T, var max: T) {
    val valid: Boolean get() = min <= max
}