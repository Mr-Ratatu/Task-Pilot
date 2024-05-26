package renat.task.pilot.features.projects.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import renat.task.pilot.core.data.local.dao.project.ProjectsDao
import renat.task.pilot.features.projects.model.Project
import renat.task.pilot.features.projects.model.Project.Companion.toProject

class ProjectListUseCase(private val dao: ProjectsDao) {

    operator fun invoke(): Flow<List<Project>> {
        return dao.projects.map { list ->
            list.map {
                it.toProject()
            }
        }
    }
}