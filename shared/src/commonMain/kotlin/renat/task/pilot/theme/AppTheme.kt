package renat.task.pilot.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import renat.task.pilot.theme.palette.darkPalette
import renat.task.pilot.theme.palette.lightPalette

@Composable
fun AppTheme(
    isDarkTheme: Boolean,
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