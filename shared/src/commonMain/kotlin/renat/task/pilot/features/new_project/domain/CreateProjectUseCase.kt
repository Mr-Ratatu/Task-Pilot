package renat.task.pilot.features.new_project.domain

import renat.task.pilot.core.data.services.project.ProjectService
import renat.task.pilot.core.data.model.Project

class CreateProjectUseCase(private val service: ProjectService) {
    suspend operator fun invoke(project: Project) {
        service.createProject(project)
    }
}