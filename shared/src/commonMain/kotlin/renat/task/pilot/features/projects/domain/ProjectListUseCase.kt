package renat.task.pilot.features.projects.domain

import kotlinx.coroutines.flow.Flow
import renat.task.pilot.core.data.services.project.ProjectService
import renat.task.pilot.core.data.model.Project

class ProjectListUseCase(private val projectService: ProjectService) {

    operator fun invoke(): Flow<List<Project>> = projectService.projects
}