package renat.task.pilot.core.base.platform

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import renat.task.pilot.di.getKoinInstance

actual fun getScreenSize(): DeviceSize {
    val context = getKoinInstance<Context>()
    val screenSize = context.resources.displayMetrics
    return DeviceSize(
        width = screenSize.widthPixels,
        height = screenSize.heightPixels,
    )
}

@Composable
actual fun getScreenSizeDp(): DeviceSizeDp {
    val config = LocalConfiguration.current
    val height = config.screenHeightDp.dp
    val width = config.screenWidthDp.dp

    return DeviceSizeDp(
        width = width,
        height = height,
    )
}