package renat.task.pilot.features.projects.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject
import renat.task.pilot.core.theme.AppThemeProvider
import renat.task.pilot.features.projects.presentation.components.AddNewProjectButton
import renat.task.pilot.features.projects.presentation.components.ProjectList
import renat.task.pilot.features.projects.presentation.components.ProjectToolbar
import renat.task.pilot.features.projects.presentation.intent.NavIntent

@Composable
fun ProjectScreen(viewModel: ProjectsViewModel = koinInject()) {
    val state by viewModel.state.collectAsState()

    Box {
        Column {
            ProjectToolbar()
            ProjectList(
                projects = state.projects,
                onItemClick = { viewModel.sendIntent(NavIntent.OpenKanbanBoardScreen) }
            )
        }

        AddNewProjectButton(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(AppThemeProvider.dimens.doubleContentPadding),
            onClick = { viewModel.sendIntent(NavIntent.OpenProjectCreatingScreen) }
        )
    }
}