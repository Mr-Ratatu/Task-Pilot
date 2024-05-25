package renat.task.pilot.screens.projects.presentation.intent

import renat.task.pilot.core.vm.Intent

sealed interface ProjectsIntent : Intent

sealed interface NavIntent : ProjectsIntent {
    data object OpenKanbanBoardScreen : NavIntent

    data object OpenProjectCreatingScreen : NavIntent
}
