package renat.task.pilot.features.projects.presentation.state

import renat.task.pilot.core.base.vm.State
import renat.task.pilot.core.data.model.Project

data class ProjectsState(
    val projects: List<Project>,
) : State {
    companion object {
        fun initial() = ProjectsState(
            projects = emptyList(),
        )
    }
}
