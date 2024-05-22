package renat.task.pilot.di

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.koin.core.module.Module
import org.koin.dsl.module
import renat.task.pilot.db.TaskPilotDb

actual val platformModule: Module = module {
    single<SqlDriver> {
        val driver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        TaskPilotDb.Schema.create(driver)
        driver
    }
}