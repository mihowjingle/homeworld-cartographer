package com.github.mihowjingle.cartographer.ui.model.entities

import com.github.mihowjingle.cartographer.ui.model.common.ObservablePosition
import javafx.beans.property.SimpleStringProperty
import tornadofx.getValue
import tornadofx.setValue

class ObservablePebble(type: String?, val position: ObservablePosition = ObservablePosition()) {

    val typeProperty = SimpleStringProperty(type)
    var type: String? by typeProperty

    // for tableview columns only
    val xProperty by position::xProperty
    val zProperty by position::zProperty
    val yProperty by position::yProperty
}