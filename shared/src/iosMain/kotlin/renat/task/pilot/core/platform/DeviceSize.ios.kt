package renat.task.pilot.core.platform

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo

actual fun getScreenSize(): DeviceSize {
    return DeviceSize(0, 0)
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun getScreenSizeDp(): DeviceSizeDp {
    val density = LocalDensity.current
    val config = LocalWindowInfo.current.containerSize

    return remember(density, config) {
        DeviceSizeDp(
            height = with(density) { config.height.toDp() },
            width = with(density) { config.width.toDp() }
        )
    }
}