package renat.task.pilot.screens.new_project.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import renat.task.pilot.core.theme.AppThemeProvider

@Composable
fun TagsBlock(
    tags: List<String>,
    modifier: Modifier = Modifier,
    onTagSelected: (String) -> Unit = {},
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(AppThemeProvider.dimens.contentPadding),
    ) {
        Column(
            modifier = Modifier
                .padding(AppThemeProvider.dimens.contentPadding),
            verticalArrangement = Arrangement.spacedBy(AppThemeProvider.dimens.halfContentPadding)
        ) {
            Text(
                text = "Choose project tag",
                color = AppThemeProvider.colors.hintColor,
            )

            TagListItem(
                tags = tags,
                onTagSelected = onTagSelected
            )
        }
    }
}