package renat.task.pilot.di

import org.koin.dsl.module
import renat.task.pilot.core.data.storage.dao.kanban.KanbanDao
import renat.task.pilot.core.data.storage.dao.kanban.KanbanDaoImpl
import renat.task.pilot.core.data.storage.dao.project.ProjectsDao
import renat.task.pilot.core.data.storage.dao.project.ProjectsDaoImpl
import renat.task.pilot.core.data.storage.adapters.ProjectTagsAdapter
import renat.task.pilot.db.TaskPilotDb

object StorageModule {
    val module = module {
        single { TaskPilotDb(driver = get(), ProjectTagsAdapter()) }
        single<ProjectsDao> { ProjectsDaoImpl(db = get()) }
        single<KanbanDao> { KanbanDaoImpl(db = get()) }
    }
}