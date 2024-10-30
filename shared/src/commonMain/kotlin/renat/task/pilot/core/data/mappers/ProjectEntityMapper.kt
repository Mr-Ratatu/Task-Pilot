package renat.task.pilot.core.data.mappers

import db.projects.ProjectEntity
import renat.task.pilot.core.data.model.Project

fun ProjectEntity.toProject() = Project.create(
    projectName = name,
    description = desciption,
    tags = tags,
)

fun Project.toProjectEntity(id: String) = ProjectEntity(
    id = id,
    name = projectName,
    desciption = description,
    boardId = boardId,
    tags = tags,
)
