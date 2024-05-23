package renat.task.pilot.screens.projects.presentation

import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import renat.task.pilot.core.vm.MviViewModel
import renat.task.pilot.navigation.Destinations
import renat.task.pilot.navigation.Navigator
import renat.task.pilot.screens.projects.domain.ProjectListUseCase
import renat.task.pilot.screens.projects.presentation.intent.NavIntent
import renat.task.pilot.screens.projects.presentation.intent.ProjectsIntent
import renat.task.pilot.screens.projects.presentation.reduce.ProjectsReducer
import renat.task.pilot.screens.projects.presentation.state.ProjectsState

class ProjectsViewModel(
    private val projectListUseCase: ProjectListUseCase,
    private val navigator: Navigator,
) : MviViewModel<ProjectsState, ProjectsIntent, ProjectsReducer>() {

    init {
        projectListUseCase()
            .onEach { projects -> sendReduce(ProjectsReducer.SetProjects(projects)) }
            .launchIn(viewModelScope)
    }

    override fun initialStateValue() = ProjectsState.NONE

    override fun reduce(state: ProjectsState, reducer: ProjectsReducer): ProjectsState {
        return when (reducer) {
            is ProjectsReducer.SetProjects -> state.copy(projects = reducer.projects)
        }
    }

    override fun executeIntent(intent: ProjectsIntent) {
        when (intent) {
            is NavIntent.OpenKanbanBoardScreen -> navigator.tryNavigateTo(Destinations.KanbanBoardScreen)
        }
    }
}