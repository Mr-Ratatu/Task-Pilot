package renat.task.pilot.core.view.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import renat.task.pilot.core.theme.AppThemeProvider

@Composable
internal fun TagLabel(
    tagName: String,
    defaultCheck: Boolean = false,
    onClick: (String) -> Unit = {},
) {
    var isChecked by remember { mutableStateOf(defaultCheck) }

    Row(
        modifier = Modifier
            .clickable {
                isChecked = !isChecked
                onClick(tagName)
            }
            .let { modifier ->
                if (isChecked) {
                    modifier.background(
                        color = AppThemeProvider.colors.buttonColor,
                        shape = RoundedCornerShape(8.dp)
                    )
                } else {
                    modifier
                }
            }
            .padding(
                horizontal = AppThemeProvider.dimens.halfContentPadding,
                vertical = AppThemeProvider.dimens.quarterContentPadding,
            )
    ) {
        val textColor = when (isChecked) {
            true -> AppThemeProvider.colors.buttonTextColor
            false -> AppThemeProvider.colors.titleTextColor
        }

        Text(
            text = tagName,
            color = textColor,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}