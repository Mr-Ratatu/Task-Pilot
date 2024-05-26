package renat.task.pilot.features.new_project.domain

import renat.task.pilot.features.new_project.data.NewProjectRepository
import renat.task.pilot.features.projects.model.Project
import renat.task.pilot.features.projects.model.Project.Companion.toProjectDTO

class CreateProjectUseCase(private val repository: NewProjectRepository) {
    suspend operator fun invoke(project: Project) {
        repository.createProject(project.toProjectDTO(project.projectName))
    }
}