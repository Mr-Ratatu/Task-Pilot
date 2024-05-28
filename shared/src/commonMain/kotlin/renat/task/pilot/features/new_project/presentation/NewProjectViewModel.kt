package renat.task.pilot.features.new_project.presentation

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import renat.task.pilot.core.vm.MviViewModel
import renat.task.pilot.features.new_project.domain.CreateProjectUseCase
import renat.task.pilot.features.new_project.presentation.intent.NewProjectIntent
import renat.task.pilot.features.new_project.presentation.intent.NewProjectIntent.CreateProjectIntent
import renat.task.pilot.features.new_project.presentation.intent.NewProjectIntent.ProjectDescriptionFieldChanged
import renat.task.pilot.features.new_project.presentation.intent.NewProjectIntent.ProjectNameFieldChanged
import renat.task.pilot.features.new_project.presentation.intent.NewProjectIntent.TagSelected
import renat.task.pilot.features.new_project.presentation.reducer.NewProjectReducer
import renat.task.pilot.features.new_project.presentation.reducer.NewProjectReducer.SetProjectDescription
import renat.task.pilot.features.new_project.presentation.reducer.NewProjectReducer.SetProjectName
import renat.task.pilot.features.new_project.presentation.reducer.NewProjectReducer.SetProjectTag
import renat.task.pilot.features.new_project.presentation.state.NewProjectState
import renat.task.pilot.features.projects.model.Project

class NewProjectViewModel(
    private val createProjectUseCase: CreateProjectUseCase,
): MviViewModel<NewProjectState, NewProjectIntent, NewProjectReducer>() {
    override fun initialStateValue(): NewProjectState = NewProjectState.initial()

    override fun reduce(
        state: NewProjectState,
        reducer: NewProjectReducer
    ) = when (reducer) {
        is SetProjectName -> state.copy(projectInputName = reducer.projectName)
        is SetProjectDescription -> state.copy(description = reducer.description)
        is SetProjectTag -> state.copy(chosenTags = state.chosenTags.appendAndGetTags(reducer.tag))
        else -> state
    }

    override fun executeIntent(intent: NewProjectIntent) {
        when (intent) {
            is ProjectNameFieldChanged -> sendReduce(SetProjectName(intent.newValue))
            is ProjectDescriptionFieldChanged -> sendReduce(SetProjectDescription(intent.newValue))
            is TagSelected -> sendReduce(SetProjectTag(intent.tag))
            is CreateProjectIntent -> createProject()
        }
    }

    private fun createProject() {
        val state = state.value
        val project = Project.create(
            projectName = state.projectInputName,
            description = state.description,
            tags = state.chosenTags,
        )
        viewModelScope.launch(Dispatchers.IO) { createProjectUseCase(project) }
    }

    private fun List<String>.appendAndGetTags(newTag: String): List<String> {
        return buildList {
            addAll(this@appendAndGetTags)
            if (contains(newTag)) remove(newTag) else add(newTag)
        }
    }
}