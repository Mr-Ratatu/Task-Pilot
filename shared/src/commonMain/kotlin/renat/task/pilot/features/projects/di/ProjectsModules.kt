package renat.task.pilot.features.projects.di

import org.koin.dsl.module
import renat.task.pilot.core.data.local.dao.project.ProjectsDao
import renat.task.pilot.core.data.local.dao.project.ProjectsDaoImpl
import renat.task.pilot.features.projects.domain.ProjectListUseCase
import renat.task.pilot.features.projects.presentation.ProjectsViewModel

object ProjectsModules {
    val module = module {
        single<ProjectsDao> { ProjectsDaoImpl(db = get()) }

        factory<ProjectListUseCase> { ProjectListUseCase(get()) }

        factory { ProjectsViewModel(projectListUseCase = get(), navigator = get()) }
    }
}