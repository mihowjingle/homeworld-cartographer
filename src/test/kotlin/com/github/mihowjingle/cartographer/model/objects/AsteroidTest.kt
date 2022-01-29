package com.github.mihowjingle.cartographer.model.objects

import com.github.mihowjingle.cartographer.model.common.Position
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class AsteroidTest : FunSpec({

    val asteroid1 = Asteroid(Asteroid.Type.ASTEROID_3, Position(1.0, 2.0, 3.0), 110)
    val asteroid2 = Asteroid(Asteroid.Type.ASTEROID_2_MP, Position(6.0, 5.0, 4.0), 50)

    test("an asteroid should return the correct amount of actual RUs") {
        asteroid1.effectiveRus shouldBe 9900
        asteroid2.effectiveRus shouldBe 1800
    }

    test("an asteroid should return the correct .level file representation") {
        asteroid1.toLua() shouldBe "addAsteroid(\"Asteroid_3\", {1.0, 2.0, 3.0}, 110, 0.000, 0.000, 0.000, 0)"
        asteroid2.toLua() shouldBe "addAsteroid(\"Asteroid2_MP\", {6.0, 5.0, 4.0}, 50, 0.000, 0.000, 0.000, 0)"
    }
})
