package com.github.mihowjingle.cartographer.ui.views

import com.github.mihowjingle.cartographer.ui.controllers.ApplicationController
import com.github.mihowjingle.cartographer.ui.model.entities.ObservablePebble
import javafx.scene.control.TableView
import tornadofx.Fragment
import tornadofx.column
import tornadofx.onDoubleClick
import tornadofx.tableview

class PebblesTableView : Fragment("Pebbles") {

    private val controller: ApplicationController by inject()

    override val root = tableview(controller.currentLevel.pebbles) {
        columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY
        column("Type", ObservablePebble::labelProperty) {
            minWidth = 100.0
        }
        column("x", ObservablePebble::xProperty) {
            minWidth = 100.0
        }
        column("z", ObservablePebble::zProperty) {
            minWidth = 100.0
        }
        column("y", ObservablePebble::yProperty) {
            minWidth = 100.0
        }
        onDoubleClick {
            find<PebbleEditView>(mapOf(PebbleEditView::pebble to selectionModel.selectedItem)).openModal()
        }
    }
}