package com.github.mihowjingle.cartographer.testutils

/**
 * For nice formatting of test names, instead of a Boolean: "something $shouldBe something"
 * Gives:
 * - "something should be something" or
 * - "something should not be something"
 * accordingly
 */
enum class ShouldBe(private val label: String, val boolean: Boolean) {
    YES("should be", true),
    NO("should not be", false);

    override fun toString() = label
}