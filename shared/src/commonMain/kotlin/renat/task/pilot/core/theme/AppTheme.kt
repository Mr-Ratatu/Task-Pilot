package renat.task.pilot.core.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import renat.task.pilot.core.theme.palette.darkPalette
import renat.task.pilot.core.theme.palette.lightPalette

@Composable
fun AppTheme(
    isDarkTheme: Boolean = false,
    content: @Composable () -> Unit,
) {
    val dimens = AppDimens()
    val colors = if (isDarkTheme) darkPalette else lightPalette
    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppDimens provides dimens,
    ) {
        content()
    }
}

val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("CompositionLocal AppColor not present")
}

val LocalAppDimens = staticCompositionLocalOf<AppDimens> {
    error("CompositionLocal AppDimens not present")
}

object AppThemeProvider {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val dimens: AppDimens
        @Composable
        @ReadOnlyComposable
        get() = LocalAppDimens.current
}