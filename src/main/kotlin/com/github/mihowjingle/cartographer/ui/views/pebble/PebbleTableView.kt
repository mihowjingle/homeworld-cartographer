package com.github.mihowjingle.cartographer.ui.views.pebble

import com.github.mihowjingle.cartographer.ui.controllers.ApplicationController
import com.github.mihowjingle.cartographer.ui.model.entities.ObservablePebble
import javafx.scene.control.TableView
import tornadofx.Fragment
import tornadofx.column
import tornadofx.onDoubleClick
import tornadofx.tableview

class PebbleTableView : Fragment("Pebbles") {

    private val controller: ApplicationController by inject()

    override val root = tableview(controller.currentLevel.pebbles) {
        columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY
        column("Type", ObservablePebble::labelProperty) {
            minWidth = 100.0
        }
        column("Position: x", ObservablePebble::xProperty) {
            minWidth = 100.0
        }
        column("Position: z", ObservablePebble::zProperty) {
            minWidth = 100.0
        }
        column("Position: y", ObservablePebble::yProperty) {
            minWidth = 100.0
        }
        onDoubleClick {
            if (selectionModel.selectedItem != null) {
                find<PebbleEditView>(mapOf(PebbleEditView::pebble to selectionModel.selectedItem)).openModal()
            }
        }
    }
}