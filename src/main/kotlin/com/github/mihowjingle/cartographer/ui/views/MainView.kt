package com.github.mihowjingle.cartographer.ui.views

import com.github.mihowjingle.cartographer.model.common.Constraint
import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.level.*
import com.github.mihowjingle.cartographer.model.objects.Pebble
import tornadofx.*

val testLevel = Level(
    "Arthur Authorsson",
    Background.HW2_01,
    3,
    Size(120000.0, 100000.0, 120000.0),
    Constraint(10000.0, 100000.0),
    Music.HW2_AMBIENT_01,
    Music.HW2_BATTLE_01,
    Fog(),
//    Fog(true, 1000.0, 4000.0, Color(120, 120, 120, 120), 0.5),
    listOf(
        Pebble(Pebble.Type.PEBBLE_0, Position(-2.0, 0.0, 0.0)),
        Pebble(Pebble.Type.PEBBLE_1, Position(0.0, 0.0, 3.0)),
        Pebble(Pebble.Type.PEBBLE_0, Position(11.0, 1.0, 3.0)),
        Pebble(Pebble.Type.PEBBLE_2, Position(0.0, 5.0, 6.0)),
        Pebble(Pebble.Type.PEBBLE_1, Position(7.0, 5.0, 0.0)),
        Pebble(Pebble.Type.PEBBLE_0, Position(0.0, 4.0, 2.0))
    ),
    listOf(),
    listOf(),
    listOf(),
    listOf(),
    listOf(),
    listOf(),
    listOf()
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