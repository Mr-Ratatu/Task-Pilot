package renat.task.pilot.features.projects.presentation.reduce

import renat.task.pilot.core.base.vm.Reducer
import renat.task.pilot.core.data.model.Project

sealed interface ProjectsReducer : Reducer {
    data class SetProjects(val projects: List<Project>) : ProjectsReducer
}