package renat.task.pilot.screens.projects.presentation.reduce

import renat.task.pilot.core.vm.Reducer
import renat.task.pilot.screens.projects.model.Project

sealed interface ProjectsReducer : Reducer {
    data class SetProjects(val projects: List<Project>) : ProjectsReducer
}