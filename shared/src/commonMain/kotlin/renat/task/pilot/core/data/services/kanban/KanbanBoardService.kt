package renat.task.pilot.core.data.services.kanban

import renat.task.pilot.core.data.storage.model.KanbanBoardEntity

interface KanbanBoardService {
    suspend fun getKanbanBoard(projectId: String): KanbanBoardEntity
}