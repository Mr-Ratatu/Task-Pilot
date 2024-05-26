package renat.task.pilot.features.projects.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import renat.task.pilot.core.theme.AppThemeProvider
import renat.task.pilot.core.view.items.TagLabel

@Composable
fun TagsList(
    tags: List<String>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(AppThemeProvider.dimens.halfContentPadding)
    ) {
        items(tags) { tag ->
            TagLabel(
                tagName = tag,
                defaultCheck = true
            )
        }
    }
}