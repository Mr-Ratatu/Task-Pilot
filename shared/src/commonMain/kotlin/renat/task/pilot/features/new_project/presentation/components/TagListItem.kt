package renat.task.pilot.features.new_project.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import renat.task.pilot.core.view.items.TagLabel
import renat.task.pilot.core.theme.AppThemeProvider

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