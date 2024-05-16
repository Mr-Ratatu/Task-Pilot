package renat.task.pilot.screens.projects.state

import renat.task.pilot.core.vm.BaseEventState

data class ProjectsState(
    val isThemeDark: Boolean = false,
) : BaseEventState {
    companion object {
        val NONE = ProjectsState()
    }
}
