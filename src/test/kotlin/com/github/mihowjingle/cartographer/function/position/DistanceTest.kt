package com.github.mihowjingle.cartographer.function.position

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlin.math.sqrt
import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition as P

class DistanceTest : FunSpec({

    test("it should correctly calculate the distance between two positions") {
        distance(P(0.0, 0.0, 0.0), P(1.0, 1.0, 1.0)) shouldBe sqrt(3.0)
        distance(P(0.0, 0.0, 0.0), P(55.0, 0.0, 0.0)) shouldBe 55.0
        distance(P(0.0, 0.0, 0.0), P(0.0, 8000.0, 0.0)) shouldBe 8000.0
        distance(P(0.0, 0.0, 0.0), P(-3.0, 0.0, 0.0)) shouldBe 3.0
        distance(P(0.0, 0.0, 0.0), P(0.0, 0.0, 0.0)) shouldBe 0.0
        distance(P(0.0, null, 0.0), P(0.0, 0.0, 0.0)) shouldBe null
        distance(P(0.0, 0.0, 0.0), P(0.0, 0.0, null)) shouldBe null
    }
})
