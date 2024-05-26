package renat.task.pilot.screens.new_project.data

import db.projects.ProjectDTO
import renat.task.pilot.core.data.local.dao.project.ProjectsDao

class NewProjectRepositoryImpl(
    private val dao: ProjectsDao,
): NewProjectRepository {
    override suspend fun createProject(project: ProjectDTO) = dao.insert(project)
}