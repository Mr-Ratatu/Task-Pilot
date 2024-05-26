package renat.task.pilot.core.data.local.dao.project

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import db.projects.ProjectDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import renat.task.pilot.db.TaskPilotDb

class ProjectsDaoImpl(db: TaskPilotDb) : ProjectsDao {
    private val queries = db.projectsCRUDQueries

    override val projects: Flow<List<ProjectDTO>> = queries
        .getAllProject()
        .asFlow()
        .mapToList(Dispatchers.Default)

    override suspend fun insert(projectDTO: ProjectDTO) = projectDTO.run {
        queries.insertProject(
            id = id,
            name = name,
            desciption = desciption,
            boardId = boardId,
            tags = tags,
        )
    }

    override suspend fun update(projectDTO: ProjectDTO) = projectDTO.run {
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