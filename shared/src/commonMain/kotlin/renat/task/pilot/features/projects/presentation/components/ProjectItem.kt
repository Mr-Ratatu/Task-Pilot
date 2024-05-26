package renat.task.pilot.features.projects.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import renat.task.pilot.core.theme.AppThemeProvider
import renat.task.pilot.features.projects.model.Project

@Composable
internal fun ProjectItem(
    project: Project,
    modifier: Modifier = Modifier,
    onClick: (Project) -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(project) },
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(
                AppThemeProvider.dimens.contentPadding
            ),
            verticalArrangement = Arrangement.spacedBy(
                AppThemeProvider.dimens.halfContentPadding
            )
        ) {
            TagsList(project.tags)
            ProjectInfoRow(project)
            ProjectParticipantsRow()
        }
    }
}

@Composable
private fun ProjectInfoRow(
    project: Project,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.height(intrinsicSize = IntrinsicSize.Min),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(AppThemeProvider.dimens.halfContentPadding)
    ) {
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(AppThemeProvider.dimens.quarterContentPadding)
                .background(
                    AppThemeProvider.colors.buttonColor,
                    RoundedCornerShape(AppThemeProvider.dimens.contentPadding)
                ),
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(AppThemeProvider.dimens.quarterContentPadding)
        ) {
            Text(
                text = project.projectName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = AppThemeProvider.colors.titleTextColor
            )

            Text(
                text = project.description,
                color = AppThemeProvider.colors.descriptionColor,
            )
        }
    }
}

@Composable
private fun ProjectParticipantsRow() {
    Text(
        text = "1 участник",
        color = AppThemeProvider.colors.descriptionColor,
    )
}