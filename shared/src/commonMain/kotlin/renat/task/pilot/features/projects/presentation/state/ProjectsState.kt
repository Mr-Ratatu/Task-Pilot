package renat.task.pilot.features.projects.presentation.state

import renat.task.pilot.core.vm.State
import renat.task.pilot.features.projects.model.Project

data class ProjectsState(
    val projects: List<Project>,
) : State {
    companion object {
        val NONE = ProjectsState(
            projects = emptyList(),
        )
    }
}
