package renat.task.pilot.screens.projects.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import renat.task.pilot.core.theme.AppThemeProvider

@Composable
fun PilotButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    TextButton(
        modifier = modifier
            .background(AppThemeProvider.colors.columnBackgroundColor, RoundedCornerShape(16.dp)),
        onClick = onClick,
    ) {
        Text(
            text = "Add new board"
        )
    }
}