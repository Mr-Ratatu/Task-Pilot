package renat.task.pilot.features.projects.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import renat.task.pilot.core.view.theme.AppThemeProvider
import renat.task.pilot.core.data.model.Project

@Composable
internal fun ProjectList(
    projects: List<Project>,
    onItemClick: (Project) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppThemeProvider.dimens.contentPadding),
        verticalArrangement = Arrangement.spacedBy(AppThemeProvider.dimens.contentPadding),
        contentPadding = PaddingValues(top = 8.dp, bottom = 88.dp),
    ) {
        projects.forEach { project ->
            item {
                ProjectItem(
                    project = project,
                    onClick = onItemClick,
                )
            }
        }
    }
}