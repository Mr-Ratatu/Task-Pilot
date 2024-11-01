package renat.task.pilot.features.new_project.presentation.intent

import renat.task.pilot.core.base.vm.Intent

interface NewProjectIntent : Intent {
    data class ProjectNameFieldChanged(val newValue: String) : NewProjectIntent

    data class ProjectDescriptionFieldChanged(val newValue: String) : NewProjectIntent

    data object CreateProjectIntent : NewProjectIntent

    data class TagSelected(val tag: String) : NewProjectIntent
}