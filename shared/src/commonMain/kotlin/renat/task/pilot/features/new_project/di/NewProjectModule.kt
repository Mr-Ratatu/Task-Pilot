package renat.task.pilot.features.new_project.di

import org.koin.dsl.module
import renat.task.pilot.features.new_project.data.NewProjectRepository
import renat.task.pilot.features.new_project.data.NewProjectRepositoryImpl
import renat.task.pilot.features.new_project.domain.CreateProjectUseCase
import renat.task.pilot.features.new_project.presentation.NewProjectViewModel

object NewProjectModule {
    val module = module {
        single<NewProjectRepository> { NewProjectRepositoryImpl(dao = get()) }
        single { CreateProjectUseCase(repository = get()) }
        factory { NewProjectViewModel(createProjectUseCase = get()) }
    }
}