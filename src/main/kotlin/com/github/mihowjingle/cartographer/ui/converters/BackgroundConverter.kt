package com.github.mihowjingle.cartographer.ui.converters

import com.github.mihowjingle.cartographer.model.dictionaries.Background

object BackgroundConverter : DictionaryConverter<Background>() {

    override fun fromString(string: String?): Background {
        return Background.values().single { it.label == string }
    }
}