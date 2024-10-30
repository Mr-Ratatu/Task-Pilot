package renat.task.pilot.features.new_project.presentation.reducer

import renat.task.pilot.core.base.vm.Reducer

interface NewProjectReducer : Reducer {
    data class SetProjectName(val projectName: String) : NewProjectReducer

    data class SetProjectDescription(val description: String) : NewProjectReducer

    data class SetProjectTag(val tag: String) : NewProjectReducer
}