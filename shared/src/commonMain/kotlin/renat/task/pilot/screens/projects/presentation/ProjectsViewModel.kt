package renat.task.pilot.screens.projects.presentation

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import renat.task.pilot.core.vm.BaseViewModel
import renat.task.pilot.screens.projects.domain.ProjectListUseCase
import renat.task.pilot.screens.projects.model.Project
import renat.task.pilot.screens.projects.state.ProjectsState

class ProjectsViewModel(
    private val projectListUseCase: ProjectListUseCase
) : BaseViewModel<ProjectsState, Nothing>() {
    val projects = projectListUseCase()

    override fun onCleared() {

    }

    override fun initState(): ProjectsState = ProjectsState.NONE
}