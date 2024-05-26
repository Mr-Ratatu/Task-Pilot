package renat.task.pilot.features.new_project.data

import db.projects.ProjectDTO

interface NewProjectRepository {
    suspend fun createProject(project: ProjectDTO)
}