package com.github.mihowjingle.cartographer.function.position

import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * @return null if it is impossible to calculate, because x/z/y of either position is null
 */
fun distance(a: ObservablePosition, b: ObservablePosition): Double? {

    val ax = a.x ?: return null
    val az = a.z ?: return null
    val ay = a.y ?: return null

    val bx = b.x ?: return null
    val bz = b.z ?: return null
    val by = b.y ?: return null

    return sqrt((ax - bx).pow(2) + (az - bz).pow(2) + (ay - by).pow(2))
}