package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Orientation
import com.github.mihowjingle.cartographer.model.common.Position
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MegalithTest : FunSpec({

    val megalith = Megalith("Megan", Megalith.Type.MEGALITH_1, Position(11.0, -9.0, -0.5), orientation = Orientation(-100.0, 200.0, 350.0))

    test("a megalith should return the correct .level file representation") {
        megalith.toLua() shouldBe "addSquadron(\"Megan\", \"meg_asteroid\", {11.0, -9.0, -0.5}, -1, {-100.0, 200.0, 350.0}, 0, 0)"
    }
})
