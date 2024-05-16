package renat.task.pilot.screens.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import renat.task.pilot.di.getKoinInstance
import renat.task.pilot.screens.projects.presentation.ProjectScreen
import renat.task.pilot.theme.AppTheme
import renat.task.pilot.theme.AppThemeProvider

@Composable
fun RootScreen() {
    AppTheme(false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AppThemeProvider.colors.backgroundColor)
        ) {
            ProjectScreen(getKoinInstance())
        }
    }
}