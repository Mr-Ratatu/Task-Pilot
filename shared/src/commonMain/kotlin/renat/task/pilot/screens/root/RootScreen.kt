package renat.task.pilot.screens.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import renat.task.pilot.di.getKoinInstance
import renat.task.pilot.screens.main.MainScreen
import renat.task.pilot.theme.AppTheme
import renat.task.pilot.theme.AppThemeProvider

@Composable
fun RootScreen() {
    AppTheme(false) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(AppThemeProvider.colors.backgroundColor)
        ) {
            MainScreen(getKoinInstance())
        }
    }
}