package renat.task.pilot.features.projects.presentation.reduce

import renat.task.pilot.core.vm.Reducer
import renat.task.pilot.features.projects.model.Project

sealed interface ProjectsReducer : Reducer {
    data class SetProjects(val projects: List<Project>) : ProjectsReducer
}