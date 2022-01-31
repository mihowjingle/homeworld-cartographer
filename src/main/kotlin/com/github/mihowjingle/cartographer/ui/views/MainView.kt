package com.github.mihowjingle.cartographer.ui.views

import com.github.mihowjingle.cartographer.model.common.Constraint
import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.entities.Asteroid
import com.github.mihowjingle.cartographer.model.entities.Pebble
import com.github.mihowjingle.cartographer.model.entities.Salvage
import com.github.mihowjingle.cartographer.model.entities.StartingPosition
import com.github.mihowjingle.cartographer.model.level.*
import tornadofx.*
import kotlin.random.Random

val testLevel = Level(
    author =                        "Arthur Authorsson",
    name =                          "Cartography",
    background =                    Background.HW2_14,
    maxPlayers =                    3,
    size =                          Size(120000.0, 100000.0, 120000.0),
    sensorsManagerCameraDistances = Constraint(10000.0, 100000.0),
    defaultMusic =                  Music.HW2_AMBIENT_14,
    battleMusic =                   Music.HW2_BATTLE_SAJUUK,
    fog =                           Fog(), // Fog(true, 1000.0, 4000.0, Color(120, 120, 120, 120), 0.5),
    pebbles = listOf(
        Pebble(Pebble.Type.PEBBLE_0, Position(-2.0, 0.0, 0.0)),
        Pebble(Pebble.Type.PEBBLE_1, Position(0.0, 0.0, 3.0)),
        Pebble(Pebble.Type.PEBBLE_0, Position(11.0, 1.0, 3.0)),
        Pebble(Pebble.Type.PEBBLE_2, Position(0.0, 5.0, 6.0)),
        Pebble(Pebble.Type.PEBBLE_1, Position(7.0, 5.0, 0.0)),
        Pebble(Pebble.Type.PEBBLE_0, Position(0.0, 4.0, 2.0))
    ),
    asteroids = listOf(
        Asteroid(Asteroid.Type.ASTEROID_3, Position(2461.0, 12324.0, 3462.0), 150.0),
        Asteroid(Asteroid.Type.ASTEROID_5, Position(234.0, 114.0, 7895.0), 120.0),
        Asteroid(Asteroid.Type.ASTEROID_3, Position(2346.0, 12345.0, 3534.0), 180.0),
        Asteroid(Asteroid.Type.ASTEROID_4, Position(3721.0, 66.0, 2657.0), 100.0),
        Asteroid(Asteroid.Type.ASTEROID1_MP, Position(35222.0, 6853.0, 342.0), 900.0),
        Asteroid(Asteroid.Type.ASTEROID1_MP, Position(727.0, 24788.0, 24611.0), 750.0),
        Asteroid(Asteroid.Type.ASTEROID4_MP, Position(34678.0, 43.0, 6889.0), 250.0)
    ),
    startingPositions = listOf(
        StartingPosition(0, Position(7000.0, 0.0, 7000.0), Random.nextDouble(360.0)),
        StartingPosition(1, Position(-9000.0, 0.0, 0.0), Random.nextDouble(360.0)),
        StartingPosition(2, Position(0.0, 0.0, -9000.0), Random.nextDouble(360.0)),
    ),
    clouds = listOf(),
    dustClouds = listOf(),
    nebulae = listOf(),
    salvage = listOf(
        Salvage(Salvage.Type.SALVAGE_LARGE_05, Position(1008.0, 3253.0, 6342.0), 200.0),
        Salvage(Salvage.Type.SALVAGE_LARGE_02, Position(3454.0, 322.0, 9807.0), 300.0),
        Salvage(Salvage.Type.SALVAGE_LARGE_01, Position(214.0, 777.0, 1234.0), 400.0),
        Salvage(Salvage.Type.SALVAGE_SMALL_04, Position(906.0, 125.0, 74321.0), 500.0),
        Salvage(Salvage.Type.SALVAGE_SMALL_06, Position(547.0, 23457.0, 1223.0), 600.0)
    ),
    megaliths = listOf()
)

class MainView : View("Homeworld Cartographer") {
    override val root = vbox {
        style {
            paddingAll = 10
        }
        button("Show pebbles").action {
            find<PebblesModal>(mapOf(PebblesModal::pebbles to testLevel.pebbles)).openModal()
        }
    }
}