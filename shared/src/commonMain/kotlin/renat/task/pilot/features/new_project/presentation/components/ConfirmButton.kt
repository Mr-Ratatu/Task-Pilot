package renat.task.pilot.features.new_project.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import renat.task.pilot.core.view.theme.AppTheme
import renat.task.pilot.core.view.theme.AppThemeProvider

@Composable
fun ConfirmButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(42.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(AppThemeProvider.colors.buttonColor),
        onClick = onClick
    ) {
        Text(
            text = "Create",
            color = AppThemeProvider.colors.buttonTextColor
        )
    }
}

@Preview
@Composable
fun ConfirmButtonPreview() {
    AppTheme(false) {
        ConfirmButton {}
    }
}