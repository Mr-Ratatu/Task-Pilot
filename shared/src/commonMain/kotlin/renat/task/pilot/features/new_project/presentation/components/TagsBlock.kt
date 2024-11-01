package renat.task.pilot.features.new_project.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import renat.task.pilot.core.view.theme.AppTheme
import renat.task.pilot.core.view.theme.AppThemeProvider

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

@Preview
@Composable
private fun TagsBlockPreview() {
    AppTheme {
        TagsBlock(
            tags = listOf("KMP", "Mobile")
        )
    }
}