package renat.task.pilot.core.base.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

data class DeviceSizeDp(
    val width: Dp,
    val height: Dp,
)

data class DeviceSize(
    val width: Int,
    val height: Int,
)

expect fun getScreenSize(): DeviceSize

@Composable
expect fun getScreenSizeDp(): DeviceSizeDp

