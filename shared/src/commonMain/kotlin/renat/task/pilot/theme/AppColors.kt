package renat.task.pilot.theme

import androidx.compose.ui.graphics.Color

data class AppColors(
    val titleTextColor: Color,
    val cardTitleColor: Color,
    val descriptionColor: Color,
    val backgroundColor: Color,
    val cardColor: Color,
    val iconColor: Color,
    val cardIconColor: Color,
    val columnBackgroundColor: Color,
)

val lightPalette = AppColors(
    titleTextColor = Color(0xFF121212),
    cardTitleColor = Color(0xFF31446C),
    descriptionColor = Color(0xFF888888),
    backgroundColor = Color(0xFFEAEFD1),
    cardColor = Color(0xFFFFFFFF),
    iconColor = Color(0xFF121212),
    cardIconColor = Color(0xFF888888),
    columnBackgroundColor = Color(0xFFF2F4F8)
)

val darkPalette = AppColors(
    titleTextColor = Color(0xFF121212),
    cardTitleColor = Color(0xFF31446C),
    descriptionColor = Color(0xFF888888),
    backgroundColor = Color(0xFFEAEFD1),
    cardColor = Color(0xFFFFFFFF),
    iconColor = Color(0xFF121212),
    cardIconColor = Color(0xFF888888),
    columnBackgroundColor = Color(0xFFF2F4F8)
)