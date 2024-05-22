package renat.task.pilot.di

import org.koin.dsl.module
import renat.task.pilot.db.TaskPilotDb

object StorageModule {
    val database = module {
        single { TaskPilotDb(driver = get()) }
    }
}