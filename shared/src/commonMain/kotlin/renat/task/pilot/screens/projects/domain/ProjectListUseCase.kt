package renat.task.pilot.screens.projects.domain

import renat.task.pilot.screens.projects.model.ProjectDto

class ProjectListUseCase {
    operator fun invoke(): List<ProjectDto> {
        return listOf(
            ProjectDto(
                "Изучить KMP",
                "Необходимо для роста хард скиллов",
                0,
            ),
            ProjectDto(
                "Изучить память Android",
                "Необходимо для роста хард скиллов",
                0,
            ),
            ProjectDto(
                "Изучить art, dalvik",
                "Необходимо для роста хард скиллов",
                0,
            ),
            ProjectDto(
                "Изучить тестирование",
                "Необходимо для роста хард скиллов",
                0,
            ),
        )
    }
}