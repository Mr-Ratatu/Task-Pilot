package renat.task.pilot.core.view.items

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import renat.task.pilot.core.theme.AppThemeProvider

@Composable
fun SimpleTextField(
    hintText: String,
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit,
) {
    var inputText by remember { mutableStateOf("") }

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = inputText,
        onValueChange = { value ->
            inputText = value
            onTextChange(value)
        },
        maxLines = 1,
        singleLine = true,
        colors = TextFieldDefaults
            .textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = AppThemeProvider.colors.iconColor
            ),
        placeholder = {
            Text(
                text = hintText,
                color = AppThemeProvider.colors.hintColor
            )
        }
    )
}