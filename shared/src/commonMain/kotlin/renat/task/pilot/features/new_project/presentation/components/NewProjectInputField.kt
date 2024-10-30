package renat.task.pilot.features.new_project.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import renat.task.pilot.core.view.atoms.SimpleTextField
import renat.task.pilot.core.view.theme.AppThemeProvider
import task_pilot.shared.generated.resources.Res
import task_pilot.shared.generated.resources.info_hint_description
import task_pilot.shared.generated.resources.info_hint_name

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
            hintText = stringResource(Res.string.info_hint_name),
            onTextChange = onNameChange
        )
    }

    Card(
        shape = RoundedCornerShape(AppThemeProvider.dimens.contentPadding),
        elevation = 1.dp
    ) {
        SimpleTextField(
            hintText = stringResource(Res.string.info_hint_description),
            onTextChange = onDescriptionChange
        )
    }
}