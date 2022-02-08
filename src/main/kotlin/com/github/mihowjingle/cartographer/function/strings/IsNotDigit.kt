package com.github.mihowjingle.cartographer.function.strings

fun String.isNotDigit() = this !in arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")