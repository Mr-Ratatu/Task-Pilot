package renat.task.pilot.core.data.storage.dao.kanban

import renat.task.pilot.core.data.storage.model.KanbanBoardEntity
import renat.task.pilot.core.data.storage.model.KanbanRowEntity
import renat.task.pilot.core.data.storage.model.TaskRowEntity
import renat.task.pilot.db.TaskPilotDb

class KanbanDaoImpl(db: TaskPilotDb) : KanbanDao {
    private val queries = db.boardCRUDQueries

    override suspend fun getBoardById(projectId: String): KanbanBoardEntity {
        val boardRecord = queries.getBoardById(projectId).executeAsOne()
        return KanbanBoardEntity(
            id = boardRecord.id,
            boardName = boardRecord.boardName,
            rows = getKanbanRows(boardRecord.id)
        )
    }

    override suspend fun createBoard(projectId: String, boardName: String) {
        queries.insertBoard(
            id = boardName.hashCode().toString(),
            projectId = projectId,
            boardName = boardName
        )
    }

    override suspend fun deleteBoard(boardId: String) {
        queries.deleteBoard(boardId)
    }

    override suspend fun createKanbanRow(boardId: String, row: KanbanRowEntity) {
        queries.insertColumn(
            id = row.id,
            boardId = boardId,
            columnName = row.columnName,
        )
    }

    override suspend fun getKanbanRows(boardId: String): List<KanbanRowEntity> {
        return queries.getRowsByBoardId(boardId).executeAsList()
            .map { record ->
                KanbanRowEntity(
                    id = record.id,
                    columnName = record.columnName,
                    tasks = getTasksByRowId(record.id)
                )
            }
    }

    private fun getTasksByRowId(rowId: String): List<TaskRowEntity> {
        return queries.getTasksById(rowId).executeAsList()
            .map {
                TaskRowEntity(
                    taskName = it.taskName
                )
            }
    }
}