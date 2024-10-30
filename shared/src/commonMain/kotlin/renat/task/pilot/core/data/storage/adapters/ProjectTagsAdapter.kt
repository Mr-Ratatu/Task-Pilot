package renat.task.pilot.core.data.storage.adapters

import app.cash.sqldelight.ColumnAdapter
import db.projects.ProjectEntity
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object ProjectTagsAdapter {
    operator fun invoke() : ProjectEntity.Adapter {
        return ProjectEntity.Adapter(Adapter())
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