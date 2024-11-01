package renat.task.pilot.features.projects.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import renat.task.pilot.core.view.theme.AppThemeProvider

@Composable
internal fun ProjectToolbar(
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                shape = RoundedCornerShape(
                    bottomEnd = AppThemeProvider.dimens.contentPadding,
                    bottomStart = AppThemeProvider.dimens.contentPadding,
                ),
                color = AppThemeProvider.colors.cardColor,
            )
            .padding(AppThemeProvider.dimens.contentPadding),
    ) {
        Text(
            text = "Projects",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = AppThemeProvider.colors.titleTextColor
        )
    }
}