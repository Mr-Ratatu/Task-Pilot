package renat.task.pilot.screens.projects.presentation

import renat.task.pilot.core.vm.BaseViewModel
import renat.task.pilot.navigation.Destinations
import renat.task.pilot.navigation.Navigator
import renat.task.pilot.screens.projects.domain.ProjectListUseCase
import renat.task.pilot.screens.projects.state.ProjectsState

class ProjectsViewModel(
    private val projectListUseCase: ProjectListUseCase,
    private val navigator: Navigator,
) : BaseViewModel<ProjectsState, Nothing>() {
    val projects = projectListUseCase()

    override fun onCleared() {

    }

    fun navigateToBoard()  {
        navigator.tryNavigateTo(Destinations.KanbanBoardScreen)
    }

    override fun initState(): ProjectsState = ProjectsState.NONE
}