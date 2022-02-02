package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Color
import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.dictionaries.DustCloudType
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DustCloudTest : FunSpec({

    val cloud = DustCloud("Claude", DustCloudType.DC_0, Position(78.0, 1.0, 4.0), Color(0, 255, 0, 255), 10.0, 20.0)

    test("a dust cloud should return the correct .level file representation") {
        cloud.toLua() shouldBe "addDustCloud(\"Claude\", \"DustCloud_0\", {78.0, 1.0, 4.0}, {0.0, 1.0, 0.0, 1.0}, 10.0, 20.0)"
    }
})
