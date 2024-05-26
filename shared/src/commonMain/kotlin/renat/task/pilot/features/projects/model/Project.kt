package renat.task.pilot.features.projects.model

import db.projects.ProjectDTO
import java.util.UUID

data class Project(
    val projectName: String,
    val description: String,
    val boardId: Long,
    val tags: List<String>,
) {
    companion object {
        fun create(
            projectName: String,
            description: String,
            tags: List<String>,
        ) : Project {
            return Project(
                projectName = projectName,
                description = description,
                boardId = UUID.randomUUID().leastSignificantBits,
                tags = tags,
            )
        }

        fun ProjectDTO.toProject(): Project {
            return Project(
                projectName = name,
                description = desciption,
                boardId = boardId,
                tags = tags,
            )
        }

        fun Project.toProjectDTO(id: String): ProjectDTO {
            return ProjectDTO(
                id = id,
                name = projectName,
                desciption = description,
                boardId = boardId,
                tags = tags,
            )
        }
    }
}
