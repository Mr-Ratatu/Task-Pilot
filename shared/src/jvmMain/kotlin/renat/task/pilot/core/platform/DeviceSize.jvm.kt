package renat.task.pilot.core.platform

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import java.awt.Toolkit

actual fun getScreenSize(): DeviceSize {
    val screenSize = Toolkit.getDefaultToolkit().screenSize
    return DeviceSize(
        width = screenSize.width,
        height = screenSize.height
    )
}

@Composable
actual fun getScreenSizeDp(): DeviceSizeDp {
    val density = LocalDensity.current
    val screenSize = getScreenSize()
    val widthInDp = (screenSize.width / density.density).dp
    val heightInDp = (screenSize.height / density.density).dp

    return DeviceSizeDp(
        width = widthInDp,
        height = heightInDp,
    )
}