package renat.task.pilot.features.board.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import renat.task.pilot.core.view.theme.AppThemeProvider
import renat.task.pilot.features.board.model.RowItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BoardScreen() {
    val listState = rememberLazyListState()

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clipToBounds(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        flingBehavior = rememberSnapFlingBehavior(listState),
        state = listState,
    ) {

    }
}

@Composable
fun ColumnBlockItem(rowItem: RowItem) {
    val state = rememberLazyListState()

    Column(
        modifier = Modifier
            .background(
                AppThemeProvider.colors.buttonColor,
                RoundedCornerShape(8.dp)
            )
            .width(300.dp)
            .fillMaxHeight()
            .padding(horizontal = 8.dp),
    ) {
        Text(
            text = rowItem.columnName.uppercase(),
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            state = state,
        ) {
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