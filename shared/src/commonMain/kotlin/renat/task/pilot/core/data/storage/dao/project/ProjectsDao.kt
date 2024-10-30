package renat.task.pilot.core.data.storage.dao.project

import db.projects.ProjectEntity
import kotlinx.coroutines.flow.Flow

interface ProjectsDao {
    val projects: Flow<List<ProjectEntity>>
    suspend fun insert(projectEntity: ProjectEntity)
    suspend fun update(projectEntity: ProjectEntity)
    suspend fun delete(id: String)
}