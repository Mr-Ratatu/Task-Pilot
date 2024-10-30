package renat.task.pilot.di

import org.koin.dsl.module
import renat.task.pilot.core.data.services.kanban.KanbanBoardService
import renat.task.pilot.core.data.services.kanban.KanbanBoardServiceImpl
import renat.task.pilot.core.data.services.project.ProjectService
import renat.task.pilot.core.data.services.project.ProjectServiceImpl

object ServiceModule {
    val module = module {
        single<ProjectService> {
            ProjectServiceImpl(
                projectDatabase = get(),
                kanbanDao = get(),
            )
        }

        single<KanbanBoardService> {
            KanbanBoardServiceImpl(
                kanbanDao = get()
            )
        }
    }
}