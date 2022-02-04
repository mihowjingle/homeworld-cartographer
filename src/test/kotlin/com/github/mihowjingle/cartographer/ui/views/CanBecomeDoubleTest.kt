package com.github.mihowjingle.cartographer.ui.views

import com.github.mihowjingle.cartographer.testutils.ShouldBe
import com.github.mihowjingle.cartographer.testutils.ShouldBe.NO
import com.github.mihowjingle.cartographer.testutils.ShouldBe.YES
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CanBecomeDoubleTest : FunSpec({

    data class Case(val string: String, val ok: ShouldBe)

    val casesIfNegativeAllowed = listOf(
        Case("",        ok = YES),
        Case("1.",      ok = YES),
        Case("1",       ok = YES),
        Case("1.1",     ok = YES),
        Case("-",       ok = YES),
        Case("-1.1",    ok = YES),
        Case("-0",      ok = YES),
        Case("-5",      ok = YES),
        Case("-0.",     ok = YES),
        Case("--",      ok = NO),
        Case(".",       ok = NO),
        Case("1..",     ok = NO),
        Case("-0..",    ok = NO),
        Case("-.",      ok = NO),
        Case("1.1.",    ok = NO),
        Case("1.1.1",   ok = NO),
    )

    val casesIfNegativeNotAllowed = listOf(
        Case("",        ok = YES),
        Case("1.",      ok = YES),
        Case("1",       ok = YES),
        Case("1.1",     ok = YES),
        Case(".",       ok = NO),
        Case("1..",     ok = NO),
        Case("-",       ok = NO),
        Case("--",      ok = NO),
        Case("-1.1",    ok = NO),
        Case("-0",      ok = NO),
        Case("-0.",     ok = NO),
        Case("-0..",    ok = NO),
        Case("-.",      ok = NO),
        Case("1.1.",    ok = NO),
        Case("1.1.1",   ok = NO),
    )

    context("string should (not) be a candidate for a Double value accordingly") {
        for (case in casesIfNegativeAllowed) {
            with(case) {
                test("\"$string\" $ok a candidate for Double if negative is allowed") {
                    string.canBecomeDouble(allowNegative = true) shouldBe ok.boolean
                }
            }
        }
        for (case in casesIfNegativeNotAllowed) {
            with(case) {
                test("\"$string\" $ok a candidate for Double if negative is not allowed") {
                    string.canBecomeDouble(allowNegative = false) shouldBe ok.boolean
                }
            }
        }
    }
})
