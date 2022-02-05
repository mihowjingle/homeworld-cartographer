package com.github.mihowjingle.cartographer.ui.converters

import com.github.mihowjingle.cartographer.model.dictionaries.PebbleType

object PebbleTypeConverter : DictionaryConverter<PebbleType?>() {

    override fun fromString(string: String?): PebbleType {
        return PebbleType.values().single { it.label == string }
    }
}