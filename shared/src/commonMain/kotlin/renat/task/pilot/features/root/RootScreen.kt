package renat.task.pilot.features.root

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import renat.task.pilot.features.main.MainScreen
import renat.task.pilot.core.theme.AppTheme
import renat.task.pilot.core.theme.AppThemeProvider

@Composable
fun RootScreen() {
    AppTheme(false) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(AppThemeProvider.colors.backgroundColor)
        ) {
            MainScreen()
        }
    }
}