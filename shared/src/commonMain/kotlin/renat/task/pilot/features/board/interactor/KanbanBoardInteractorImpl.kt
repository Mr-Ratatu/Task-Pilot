package renat.task.pilot.features.board.interactor

import renat.task.pilot.core.data.services.kanban.KanbanBoardService
import renat.task.pilot.features.board.model.KanbanBoardItem
import renat.task.pilot.features.board.model.RowItem
import renat.task.pilot.features.board.model.TaskItem

class KanbanBoardInteractorImpl(
    private val kanbanBoardService: KanbanBoardService,
): KanbanBoardInteractor {

    // TODO NEED REFACTOR
    override suspend fun getKanbanBoard(projectId: String): KanbanBoardItem {
        val kanbanEntity = kanbanBoardService.getKanbanBoard(projectId)
        return KanbanBoardItem(
            name = kanbanEntity.boardName,
            rows = kanbanEntity.rows.map {
                RowItem(
                    it.columnName,
                    it.tasks.map { TaskItem(it.taskName) }
                )
            }
        )
    }
}