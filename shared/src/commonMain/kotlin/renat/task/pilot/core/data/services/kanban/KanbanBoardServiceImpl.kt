package renat.task.pilot.core.data.services.kanban

import renat.task.pilot.core.data.storage.dao.kanban.KanbanDao
import renat.task.pilot.core.data.storage.model.KanbanBoardEntity

class KanbanBoardServiceImpl(
    private val kanbanDao: KanbanDao
): KanbanBoardService {
    override suspend fun getKanbanBoard(projectId: String): KanbanBoardEntity {
        return kanbanDao.getBoardById(projectId)
    }
}