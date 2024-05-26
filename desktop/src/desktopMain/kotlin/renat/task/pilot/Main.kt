package renat.task.pilot

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import renat.task.pilot.di.initKoin
import renat.task.pilot.features.root.RootScreen

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = { exitApplication() },
            state = rememberWindowState(),
            title = "Task Pilot"
        ) {
            RootScreen()
        }
    }
}