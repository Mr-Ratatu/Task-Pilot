package renat.task.pilot.core.data.storage.dao.project

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import renat.task.pilot.db.TaskPilotDb
import db.projects.ProjectEntity

class ProjectsDaoImpl(db: TaskPilotDb) : ProjectsDao {
    private val queries = db.projectsCRUDQueries

    override val projects: Flow<List<ProjectEntity>> = queries
        .getAllProject()
        .asFlow()
        .mapToList(Dispatchers.Default)

    override suspend fun insert(projectEntity: ProjectEntity) = projectEntity.run {
        queries.insertProject(
            id = id,
            name = name,
            desciption = desciption,
            boardId = boardId,
            tags = tags,
        )
    }

    override suspend fun update(projectEntity: ProjectEntity) = projectEntity.run {
        queries.updateProject(
            id = id,
            name = name,
            desciption = desciption,
            boardId = boardId,
            tags = tags,
        )
    }

    override suspend fun delete(id: String) = queries.deleteProejct(id)
}