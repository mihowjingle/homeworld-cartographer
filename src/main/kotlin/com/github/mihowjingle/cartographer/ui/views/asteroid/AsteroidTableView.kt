package com.github.mihowjingle.cartographer.ui.views.asteroid

import com.github.mihowjingle.cartographer.ui.controllers.ApplicationController
import com.github.mihowjingle.cartographer.ui.model.entities.ObservableAsteroid
import javafx.scene.control.TableView
import tornadofx.Fragment
import tornadofx.column
import tornadofx.onDoubleClick
import tornadofx.tableview

class AsteroidTableView : Fragment("Asteroids") {

    private val controller: ApplicationController by inject()

    override val root = tableview(controller.currentLevel.asteroids) {
        columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY
        column("Type", ObservableAsteroid::typeProperty) {
            minWidth = 100.0
        }
        column("Position: x", ObservableAsteroid::xProperty) {
            minWidth = 100.0
        }
        column("Position: z", ObservableAsteroid::zProperty) {
            minWidth = 100.0
        }
        column("Position: y", ObservableAsteroid::yProperty) {
            minWidth = 100.0
        }
        column("% of default RUs", ObservableAsteroid::percentOfDefaultRusProperty) {
            minWidth = 100.0
        }
        column("Effective RUs", ObservableAsteroid::effectiveRusProperty) {
            minWidth = 100.0
        }
        column("Init. orient.: x axis", ObservableAsteroid::initialOrientationXAxisProperty) {
            minWidth = 100.0
        }
        column("Init. orient.: z axis", ObservableAsteroid::initialOrientationYAxisProperty) {
            minWidth = 100.0
        }
        column("Init. orient.: y axis", ObservableAsteroid::initialOrientationZAxisProperty) {
            minWidth = 100.0
        }
        onDoubleClick {
//            if (selectionModel.selectedItem != null) {
//                find<AsteroidEditView>(mapOf(AsteroidEditView::asteroid to selectionModel.selectedItem)).openModal()
//            }
        }
    }
}