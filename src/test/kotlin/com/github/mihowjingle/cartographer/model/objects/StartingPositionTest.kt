package com.github.mihowjingle.cartographer.model.objects

import com.github.mihowjingle.cartographer.model.common.Position
import com.github.mihowjingle.cartographer.model.common.Rotation
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StartingPositionTest : FunSpec({

    // todo when introducing model for an entire level,
    //  add level-sensitive check (7th player for 5-player map??)
    test("it should be impossible to construct a starting position for an invalid player") {
        val exception1 = shouldThrow<IllegalArgumentException> {
            StartingPosition(-1, Position(1, 1, 1), Rotation(1, 2, 3))
        }
        exception1.message shouldBe "Invalid play index -1! 0..7 allowed."

        val exception2 = shouldThrow<IllegalArgumentException> {
            StartingPosition(8, Position(1, 1, 1), Rotation(1, 2, 3))
        }
        exception2.message shouldBe "Invalid play index 8! 0..7 allowed."
    }

    test("a starting position should return the correct .level file representation") {
        val sp1 = StartingPosition(0, Position(1, 1.009, 11), Rotation(11, 22, 33))
        val sp2 = StartingPosition(1, Position(7, -0.4, 0), Rotation(-0.9, -22, 3.1111))

        sp1.toLua() shouldBe "addPoint(\"StartPos0\", {1, 1.009, 11}, {11, 22, 33})"
        sp2.toLua() shouldBe "addPoint(\"StartPos1\", {7, -0.4, 0}, {-0.9, -22, 3.1111})"
    }
})
