package renat.task.pilot.screens.projects.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import renat.task.pilot.screens.projects.presentation.items.PilotButton
import renat.task.pilot.screens.projects.presentation.items.ProjectList
import renat.task.pilot.screens.projects.presentation.items.ProjectToolbar

@Composable
fun ProjectScreen(viewModel: ProjectsViewModel) {
    val projects by viewModel.projects.collectAsState(emptyList())

    Column {
        ProjectToolbar(viewModel)
        PilotButton { viewModel.navigateToBoard() }
        ProjectList(projects)
    }
}