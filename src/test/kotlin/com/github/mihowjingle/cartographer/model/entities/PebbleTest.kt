package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Position
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PebbleTest : FunSpec({

    test("a pebble should return the correct .level file representation") {
        val pebble = Pebble(Pebble.Type.PEBBLE_1, Position(x = 1.0, z = 5.1, y = 9.99998))
        pebble.toLua() shouldBe "addPebble(\"Pebble_1\", {1.0, 5.1, 9.99998}, 0.0, 0.0, 0.0)"
    }
})
