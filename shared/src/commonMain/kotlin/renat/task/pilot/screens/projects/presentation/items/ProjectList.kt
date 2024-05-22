package renat.task.pilot.screens.projects.presentation.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import renat.task.pilot.screens.projects.model.Project

@Composable
internal fun ProjectList(projects: List<Project>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(top = 8.dp, bottom = 88.dp),
    ) {
        projects.forEach { project ->
            item {
                ProjectItem(
                    project,
                )
            }
        }
    }
}