package renat.task.pilot.screens.projects.presentation.state

import renat.task.pilot.core.vm.State
import renat.task.pilot.screens.projects.model.Project

data class ProjectsState(
    val projects: List<Project>,
) : State {
    companion object {
        val NONE = ProjectsState(
            projects = emptyList(),
        )
    }
}
