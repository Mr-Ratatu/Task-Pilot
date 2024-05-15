package renat.task.pilot.screens.projects.di

import org.koin.dsl.module
import renat.task.pilot.screens.projects.domain.ProjectListUseCase

object ProjectsModules {
    val module = module {
        single<ProjectListUseCase> { ProjectListUseCase() }
    }
}