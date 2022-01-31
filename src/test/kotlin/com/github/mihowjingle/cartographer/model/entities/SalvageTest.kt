package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Position
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SalvageTest : FunSpec({

    val salvage = Salvage(Salvage.Type.SALVAGE_LARGE_03, Position(1.0, 2.0, 3.0), 110.0)

    test("salvage should return the correct amount of actual RUs") {
        salvage.effectiveRus shouldBe 770.0
    }

    test("salvage should return the correct .level file representation") {
        salvage.toLua() shouldBe "addSalvage(\"Slv_Chunk_Lrg03\", {1.0, 2.0, 3.0}, 110.0, 0, 0, 0, 0)"
    }
})
