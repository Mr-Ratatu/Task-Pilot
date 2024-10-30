package renat.task.pilot.core.data.services.project

import db.projects.ProjectEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import renat.task.pilot.core.data.storage.dao.project.ProjectsDao
import renat.task.pilot.core.data.mappers.toProject
import renat.task.pilot.core.data.mappers.toProjectEntity
import renat.task.pilot.core.data.storage.dao.kanban.KanbanDao
import renat.task.pilot.core.data.model.Project

class ProjectServiceImpl(
    private val projectDatabase: ProjectsDao,
    private val kanbanDao: KanbanDao,
): ProjectService {

    override val projects: Flow<List<Project>> = projectDatabase
        .projects
        .map { projectsList -> projectsList.map(ProjectEntity::toProject) }

    override suspend fun createProject(project: Project) {
        val projectId = project.projectName.hashCode().toString()

        projectDatabase.insert(project.toProjectEntity(id = projectId))
        kanbanDao.createBoard(projectId, project.projectName)
    }
}