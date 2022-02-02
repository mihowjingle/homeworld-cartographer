package com.github.mihowjingle.cartographer.model.entities

import com.github.mihowjingle.cartographer.model.common.Color
import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.dictionaries.CloudType
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CloudTest : FunSpec({

    val cloud = Cloud("Claude", CloudType.CLOUD_NO_RES, Position(0.0, 1000.0, 1234.0), Color(0, 255, 0, 255), 10.0, 20.0)

    test("a cloud should return the correct .level file representation") {
        cloud.toLua() shouldBe "addCloud(\"Claude\", \"Cloud_NoRes\", {0.0, 1000.0, 1234.0}, {0.0, 1.0, 0.0, 1.0}, 10.0, 20.0)"
    }
})
