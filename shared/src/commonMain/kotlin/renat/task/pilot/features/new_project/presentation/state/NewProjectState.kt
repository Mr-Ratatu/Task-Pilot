package renat.task.pilot.features.new_project.presentation.state

import renat.task.pilot.core.vm.State

data class NewProjectState(
    val projectInputName: String,
    val description: String,
    val tags: List<String>,
    val chosenTags: List<String>,
) : State {
    companion object {
        fun initial() = NewProjectState(
            projectInputName = "",
            description = "",
            tags = listOf("KMP", "Android", "Mobile", "Desktop"),
            chosenTags = emptyList(),
        )
    }
}
