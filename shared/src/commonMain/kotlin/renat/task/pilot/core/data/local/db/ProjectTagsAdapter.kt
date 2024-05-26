package renat.task.pilot.core.data.local.db

import app.cash.sqldelight.ColumnAdapter
import db.projects.ProjectDTO
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object ProjectTagsAdapter {
    operator fun invoke() : ProjectDTO.Adapter {
        return ProjectDTO.Adapter(Adapter())
    }

    private class Adapter : ColumnAdapter<List<String>, String> {
        override fun decode(databaseValue: String): List<String> {
            return Json.decodeFromString(databaseValue)
        }

        override fun encode(value: List<String>): String {
            return Json.encodeToString(value)
        }
    }
}