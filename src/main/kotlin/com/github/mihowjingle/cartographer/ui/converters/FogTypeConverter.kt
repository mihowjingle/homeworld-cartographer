package com.github.mihowjingle.cartographer.ui.converters

import com.github.mihowjingle.cartographer.model.dictionaries.FogType

object FogTypeConverter : DictionaryConverter<FogType>() {

    override fun fromString(string: String?): FogType {
        return FogType.values().single { it.label == string }
    }
}