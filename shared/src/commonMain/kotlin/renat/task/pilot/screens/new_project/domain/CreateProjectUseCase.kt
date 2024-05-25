package renat.task.pilot.screens.new_project.domain

import renat.task.pilot.screens.new_project.data.NewProjectRepository
import renat.task.pilot.screens.projects.model.Project
import renat.task.pilot.screens.projects.model.Project.Companion.toProjectDTO

class CreateProjectUseCase(private val repository: NewProjectRepository) {
    suspend operator fun invoke(project: Project) {
        repository.createProject(project.toProjectDTO(project.projectName))
    }
}