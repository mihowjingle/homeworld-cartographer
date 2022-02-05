package com.github.mihowjingle.cartographer.ui.model.common

import com.github.mihowjingle.cartographer.model.common.Constraint

/**
 * UI version of [Constraint]
 */
data class ObservableConstraint<T : Comparable<T>>(var min: T, var max: T) {
    val valid: Boolean get() = min <= max
}