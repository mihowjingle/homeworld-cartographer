package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Color
import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.dictionaries.NebulaType
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class NebulaTest : FunSpec({

    val nebula = Nebula(
        "Natalie",
        NebulaType.NEBULA_MP_BENTUSI_RADIATION,
        Position(0.0, 3.0, 7.0),
        Color(255, 0, 0, 255),
        123.0,
        321.0
    )

    test("a nebula should return the correct .level file representation") {
        nebula.toLua() shouldBe "addNebula(\"Natalie\", \"MP_Bentusi_Radiation\", {0.0, 3.0, 7.0}, {1.0, 0.0, 0.0, 1.0}, 123.0, 321.0)"
    }
})
