package renat.task.pilot.core.data.storage.dao.kanban

import renat.task.pilot.core.data.storage.model.KanbanBoardEntity
import renat.task.pilot.core.data.storage.model.KanbanRowEntity

interface KanbanDao {
    suspend fun getBoardById(projectId: String): KanbanBoardEntity
    suspend fun createBoard(projectId: String, boardName: String)
    suspend fun deleteBoard(boardId: String)

    suspend fun getKanbanRows(boardId: String): List<KanbanRowEntity>
    suspend fun createKanbanRow(boardId: String, row: KanbanRowEntity)
}