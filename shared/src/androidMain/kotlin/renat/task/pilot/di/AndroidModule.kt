package renat.task.pilot.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.koin.core.module.Module
import org.koin.dsl.module
import renat.task.pilot.db.TaskPilotDb

actual val platformModule: Module = module {
    single<SqlDriver> { AndroidSqliteDriver(TaskPilotDb.Schema, get(), "TaskPilotDb") }
}