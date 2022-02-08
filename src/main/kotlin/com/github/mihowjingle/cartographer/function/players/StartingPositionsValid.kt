package com.github.mihowjingle.cartographer.function.players

import com.github.mihowjingle.cartographer.function.position.distance
import com.github.mihowjingle.cartographer.ui.model.entities.ObservableStartingPosition

fun valid(startingPositions: List<ObservableStartingPosition>): Boolean {
    for (i in 0..startingPositions.lastIndex) {
        for (j in i + 1..startingPositions.lastIndex) {
            if (startingPositions[i] isTooCloseTo startingPositions[j]) {
                return false
            }
        }
    }
    return true
}

private const val minAcceptableDistance = 8000.0 // 8km (for Crimson Bond it's about 9km) todo configurable?

private infix fun ObservableStartingPosition.isTooCloseTo(other: ObservableStartingPosition): Boolean {
    val distance = distance(this.position, other.position)
    return distance == null || distance <= minAcceptableDistance
}
