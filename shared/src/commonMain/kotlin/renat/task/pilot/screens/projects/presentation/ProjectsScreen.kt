package renat.task.pilot.screens.projects.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.compose.koinInject
import renat.task.pilot.screens.projects.presentation.intent.NavIntent
import renat.task.pilot.screens.projects.presentation.components.PilotButton
import renat.task.pilot.screens.projects.presentation.components.ProjectList
import renat.task.pilot.screens.projects.presentation.components.ProjectToolbar

@Composable
fun ProjectScreen(viewModel: ProjectsViewModel = koinInject()) {
    val state by viewModel.state.collectAsState()

    Column {
        ProjectToolbar()
        PilotButton(
            onClick = { viewModel.sendIntent(NavIntent.OpenKanbanBoardScreen) }
        )
        ProjectList(state.projects)
    }
}