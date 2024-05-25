package renat.task.pilot.screens.new_project.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import renat.task.pilot.core.items.TagLabel
import renat.task.pilot.theme.AppThemeProvider

@Composable
fun TagListItem(
    tags: List<String>,
    onTagSelected: (tag: String) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(AppThemeProvider.dimens.halfContentPadding)
    ) {
        items(tags) { tag ->
            TagLabel(
                tagName = tag,
                onClick = onTagSelected
            )
        }
    }
}