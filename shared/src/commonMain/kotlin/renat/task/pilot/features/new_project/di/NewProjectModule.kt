package renat.task.pilot.features.new_project.di

import org.koin.dsl.module
import renat.task.pilot.features.new_project.domain.CreateProjectUseCase
import renat.task.pilot.features.new_project.presentation.NewProjectViewModel

object NewProjectModule {
    val module = module {
        single { CreateProjectUseCase(service = get()) }
        factory { NewProjectViewModel(createProjectUseCase = get()) }
    }
}