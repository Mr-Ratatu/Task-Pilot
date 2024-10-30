package renat.task.pilot.features.board.model

data class RowItem(
    val columnName: String,
    val tasks: List<TaskItem>,
)
