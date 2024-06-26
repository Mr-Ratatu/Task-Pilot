package renat.task.pilot.di

import org.koin.dsl.module
import renat.task.pilot.core.data.local.db.ProjectTagsAdapter
import renat.task.pilot.db.TaskPilotDb

object StorageModule {
    val module = module {
        single { TaskPilotDb(driver = get(), ProjectTagsAdapter()) }
    }
}