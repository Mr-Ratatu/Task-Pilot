package renat.task.pilot.core.data.model

import java.util.UUID

data class Project private constructor(
    val projectName: String,
    val description: String?,
    val boardId: Long,
    val tags: List<String>?,
) {
    companion object {
        fun create(
            projectName: String,
            description: String? = null,
            tags: List<String>? = null,
        ) : Project {
            return Project(
                projectName = projectName,
                description = description,
                boardId = UUID.randomUUID().leastSignificantBits,
                tags = tags,
            )
        }
    }
}
