package renat.task.pilot.core.data.local.dao.project

import db.projects.ProjectDTO
import kotlinx.coroutines.flow.Flow

interface ProjectsDao {
    val projects: Flow<List<ProjectDTO>>
    suspend fun insert(projectDTO: ProjectDTO)
    suspend fun update(projectDTO: ProjectDTO)
    suspend fun delete(id: String)
}