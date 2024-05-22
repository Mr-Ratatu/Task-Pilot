package renat.task.pilot.screens.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import renat.task.pilot.screens.projects.presentation.items.ProjectItem
import renat.task.pilot.screens.projects.model.Project
import renat.task.pilot.theme.AppThemeProvider

@Composable
fun BoardScreen() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(ColumnItem.default) { card ->
            ColumnBlockItem(card)
        }
    }
}

@Composable
fun ColumnBlockItem(columnItem: ColumnItem) {
    val state = rememberLazyListState()

    Column(
        modifier = Modifier
            .background(
                AppThemeProvider.colors.columnBackgroundColor,
                RoundedCornerShape(8.dp)
            )
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
    ) {
        Text(
            text = columnItem.title.uppercase(),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            state = state,
        ) {
            items(columnItem.items) { item ->
                ProjectItem(item)
            }
        }
    }
}

@Composable
fun AddCardButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(32.dp)
    ) {
        Text(
            text = "Новая карточка"
        )
    }
}

data class ColumnItem(
    val title: String,
    val items: List<Project>
) {
    companion object {

        val default = buildList<ColumnItem> {
            val projects = listOf(
                Project(
                    "Изучить KMP",
                    "Необходимо для роста хард скиллов",
                    0,
                ),
                Project(
                    "Изучить память Android",
                    "Необходимо для роста хард скиллов",
                    0,
                ),
                Project(
                    "Изучить art, dalvik",
                    "Необходимо для роста хард скиллов",
                    0,
                ),
                Project(
                    "Изучить тестирование",
                    "Необходимо для роста хард скиллов",
                    0,
                ),
                Project(
                    "Изучить тестирование",
                    "Необходимо для роста хард скиллов",
                    0,
                ),
                Project(
                    "Изучить тестирование",
                    "Необходимо для роста хард скиллов",
                    0,
                ),
            )
            add(
                ColumnItem(
                    title = "TO DO",
                    items = projects
                )
            )
            add(
                ColumnItem(
                    title = "need improvements",
                    items = projects
                )
            )
            add(
                ColumnItem(
                    title = "review",
                    items = projects
                )
            )
            add(
                ColumnItem(
                    title = "done",
                    items = projects
                )
            )
        }
    }
}