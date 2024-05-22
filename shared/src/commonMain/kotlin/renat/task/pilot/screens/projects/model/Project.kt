package renat.task.pilot.screens.projects.model

import db.projects.ProjectDTO

data class Project(
    val projectName: String,
    val description: String,
    val boardId: Long,
) {
    companion object {
        fun ProjectDTO.toProject(): Project {
            return Project(
                projectName = name,
                description = desciption,
                boardId = boardId
            )
        }
    }
}
