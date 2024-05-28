package renat.task.pilot.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module
import renat.task.pilot.features.main.di.MainModule
import renat.task.pilot.features.new_project.di.NewProjectModule
import renat.task.pilot.features.projects.di.ProjectsModules

expect val platformModule: Module

inline fun <reified T> getKoinInstance(qualifier: Qualifier? = null): T {
    return object : KoinComponent {
        val value : T by inject(qualifier)
    }.value
}

fun initKoin(
    vararg applyModules: Module = arrayOf(module {})
) = startKoin {
    modules(
        *applyModules,
        platformModule,
        StorageModule.module,
        NavigationModule.module,
        MainModule.module,
        ProjectsModules.module,
        NewProjectModule.module,
    )
}