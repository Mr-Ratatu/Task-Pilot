package renat.task.pilot.screens.projects.presentation

import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import renat.task.pilot.core.vm.BaseViewModel
import renat.task.pilot.screens.projects.domain.ProjectListUseCase
import renat.task.pilot.screens.projects.model.ProjectDto
import renat.task.pilot.screens.projects.state.ProjectsState

class ProjectsViewModel(
    private val projectListUseCase: ProjectListUseCase
): BaseViewModel<ProjectsState, Nothing>() {
    val projects = flow {
        val projects = projectListUseCase()
        val fullList = mutableListOf<ProjectDto>()
        fullList.addAll(projects)
        fullList.addAll(projects)
        fullList.addAll(projects)
        fullList.addAll(projects)
        emit(fullList)
    }.stateIn(
        viewModelScope,
        SharingStarted.Eagerly,
        emptyList()
    )

    override fun onCleared() {

    }

    override fun initState(): ProjectsState = ProjectsState.NONE
}