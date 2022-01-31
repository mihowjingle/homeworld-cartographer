package com.github.mihowjingle.cartographer.model.entities

/**
 * An object on the map (level), which is able to "export" itself to lua based on its state,
 * without any additional context or parameters.
 *
 * Coincidentally - an object which has many-to-one relation with a map (level),
 * also a common property of every [LevelEntity] is [com.github.mihowjingle.cartographer.model.common.Position],
 * neither of which matters, for now, at least.
 */
interface LevelEntity {
    fun toLua(): String
}