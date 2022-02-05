package com.github.mihowjingle.cartographer.ui.converters

import com.github.mihowjingle.cartographer.model.dictionaries.Music

object MusicConverter : DictionaryConverter<Music?>() {

    override fun fromString(string: String?): Music {
        return Music.values().single { it.label == string }
    }
}