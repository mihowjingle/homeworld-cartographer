package com.github.mihowjingle.cartographer.ui.views

import com.github.mihowjingle.cartographer.model.objects.Pebble
import javafx.scene.control.TableView
import tornadofx.*

class PebblesModal : Fragment("Pebbles") {

    val pebbles: List<Pebble> by param()

    override val root = tableview(pebbles.toObservable()) {
        columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY
        readonlyColumn("Type", Pebble::label) {
            minWidth = 100.0
        }
        readonlyColumn("x", Pebble::x) {
            minWidth = 100.0
        }
        readonlyColumn("z", Pebble::z) {
            minWidth = 100.0
        }
        readonlyColumn("y", Pebble::y) {
            minWidth = 100.0
        }
        onDoubleClick {
            // todo find<PebbleEditModal>(mapOf(PebbleEditModal::pebble to selectionModel.selectedItem)).openModal()
        }
    }
}