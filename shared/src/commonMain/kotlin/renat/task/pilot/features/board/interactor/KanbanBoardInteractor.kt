package renat.task.pilot.features.board.interactor

import renat.task.pilot.features.board.model.KanbanBoardItem

interface KanbanBoardInteractor {
    suspend fun getKanbanBoard(projectId: String): KanbanBoardItem
}