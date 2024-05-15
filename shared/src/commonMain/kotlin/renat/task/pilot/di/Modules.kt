package renat.task.pilot.di

import org.koin.dsl.module
import renat.task.pilot.screens.projects.presentation.ProjectsViewModel

object ViewModels {
    private val projectsViewModel = module {
        factory { ProjectsViewModel(get()) }
    }

    val viewModelModules = arrayOf(projectsViewModel)
}