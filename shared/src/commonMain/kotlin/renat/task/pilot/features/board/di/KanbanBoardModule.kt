package renat.task.pilot.features.board.di

import org.koin.dsl.module
import renat.task.pilot.features.board.interactor.KanbanBoardInteractor
import renat.task.pilot.features.board.interactor.KanbanBoardInteractorImpl

object KanbanBoardModule {
    val module = module {
        factory<KanbanBoardInteractor> {
            KanbanBoardInteractorImpl(
                kanbanBoardService = get()
            )
        }
    }
}