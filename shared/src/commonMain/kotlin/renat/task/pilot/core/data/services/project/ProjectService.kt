package renat.task.pilot.core.data.services.project

import kotlinx.coroutines.flow.Flow
import renat.task.pilot.core.data.model.Project

interface ProjectService {
    val projects: Flow<List<Project>>
    suspend fun createProject(project: Project)
}