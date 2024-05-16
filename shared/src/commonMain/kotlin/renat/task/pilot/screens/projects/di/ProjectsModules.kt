package renat.task.pilot.screens.projects.di

import org.koin.dsl.module
import renat.task.pilot.screens.projects.domain.ProjectListUseCase
import renat.task.pilot.screens.projects.presentation.ProjectsViewModel

object ProjectsModules {
    val module = module {
        single<ProjectListUseCase> { ProjectListUseCase() }
        factory { ProjectsViewModel(get()) }
    }
}