package renat.task.pilot.screens.new_project.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject
import renat.task.pilot.screens.new_project.presentation.components.ConfirmButton
import renat.task.pilot.screens.new_project.presentation.components.TagsBlock
import renat.task.pilot.screens.new_project.presentation.components.NewProjectInputFields
import renat.task.pilot.screens.new_project.presentation.intent.NewProjectIntent.CreateProjectIntent
import renat.task.pilot.screens.new_project.presentation.intent.NewProjectIntent.ProjectDescriptionFieldChanged
import renat.task.pilot.screens.new_project.presentation.intent.NewProjectIntent.ProjectNameFieldChanged
import renat.task.pilot.screens.new_project.presentation.intent.NewProjectIntent.TagSelected
import renat.task.pilot.theme.AppThemeProvider

@Composable
fun NewProjectScreen(viewModel: NewProjectViewModel = koinInject()) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .padding(AppThemeProvider.dimens.contentPadding),
        verticalArrangement = Arrangement.spacedBy(AppThemeProvider.dimens.contentPadding)
    ) {
        NewProjectInputFields(
            onNameChange = { newValue -> viewModel.sendIntent(ProjectNameFieldChanged(newValue)) },
            onDescriptionChange = { newValue -> viewModel.sendIntent(ProjectDescriptionFieldChanged(newValue)) }
        )

        TagsBlock(
            tags = state.tags,
            onTagSelected = { selectedTag -> viewModel.sendIntent(TagSelected(selectedTag)) }
        )

        ConfirmButton(
            modifier = Modifier.padding(top = AppThemeProvider.dimens.contentPadding),
            onClick = { viewModel.sendIntent(CreateProjectIntent) }
        )
    }
}