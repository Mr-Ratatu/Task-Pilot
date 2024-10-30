package renat.task.pilot.core.data.storage.model

data class KanbanBoardEntity(
    val id: String,
    val boardName: String,
    val rows: List<KanbanRowEntity>
)

data class KanbanRowEntity(
    val id: String,
    val columnName: String,
    val tasks: List<TaskRowEntity>
)

data class TaskRowEntity(
    val taskName: String,
)