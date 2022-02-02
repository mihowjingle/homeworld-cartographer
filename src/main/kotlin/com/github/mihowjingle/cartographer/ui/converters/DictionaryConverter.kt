package com.github.mihowjingle.cartographer.ui.converters

import com.github.mihowjingle.cartographer.model.dictionaries.Dictionary
import javafx.util.StringConverter

abstract class DictionaryConverter<D : Dictionary?> : StringConverter<D>() {
    override fun toString(dictionary: D?): String? {
        return dictionary?.label ?: ""
    }
}