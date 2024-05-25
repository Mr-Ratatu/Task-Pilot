package renat.task.pilot.screens.new_project.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import renat.task.pilot.core.items.SimpleTextField
import renat.task.pilot.theme.AppThemeProvider

@Composable
fun NewProjectInputFields(
    onNameChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit
) {
    Card(
        shape = RoundedCornerShape(AppThemeProvider.dimens.contentPadding),
        elevation = 1.dp
    ) {
        SimpleTextField(
            hintText = "Name...",
            onTextChange = onNameChange
        )
    }

    Card(
        shape = RoundedCornerShape(AppThemeProvider.dimens.contentPadding),
        elevation = 1.dp
    ) {
        SimpleTextField(
            hintText = "Description...",
            onTextChange = onDescriptionChange
        )
    }
}