package renat.task.pilot.features.board.model

data class KanbanBoardItem(
    val name: String,
    val rows: List<RowItem>
)
