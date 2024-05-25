package renat.task.pilot.screens.new_project.presentation.reducer

import renat.task.pilot.core.vm.Reducer

interface NewProjectReducer : Reducer {
    data class SetProjectName(val projectName: String) : NewProjectReducer

    data class SetProjectDescription(val description: String) : NewProjectReducer

    data class SetProjectTag(val tag: String) : NewProjectReducer
}