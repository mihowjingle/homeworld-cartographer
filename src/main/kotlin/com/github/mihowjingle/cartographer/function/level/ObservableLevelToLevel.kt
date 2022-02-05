package com.github.mihowjingle.cartographer.function.level

import com.github.mihowjingle.cartographer.model.common.Constraint
import com.github.mihowjingle.cartographer.model.level.Level
import com.github.mihowjingle.cartographer.ui.model.level.ObservableLevel

fun ObservableLevel.toPersistent() = Level(
    author = author,
    name = name ?: error("Name should not be null at this point!"),
    background = background ?: error("Background should not be null at this point!"),
    maxPlayers = maxPlayers,
    size = size.toPersistent(),
    sensorsManagerCameraDistances = Constraint(
        sensorsManagerCameraDistances.min,
        sensorsManagerCameraDistances.max
    ),
    defaultMusic = defaultMusic ?: error("Default music should not be null at this point!"),
    battleMusic = battleMusic ?: error("Battle music should not be null at this point!"),
    fog = fog.toPersistent(),
    pebbles = pebbles.map { it.toPersistent() },
    asteroids = asteroids,
    startingPositions = startingPositions,
    clouds = clouds,
    dustClouds = dustClouds,
    nebulae = nebulae,
    salvage = salvage,
    megaliths = megaliths
)