package renat.task.pilot.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

@Composable
fun AppTheme(
    isDarkTheme: Boolean,
    content: @Composable () -> Unit,
) {
    val colors = if (isDarkTheme) darkPalette else lightPalette
    CompositionLocalProvider(
        LocalAppColors provides colors
    ) {
        content()
    }
}

val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("CompositionLocal AppColor not present")
}

object AppThemeProvider {

    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current
}