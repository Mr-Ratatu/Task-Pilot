package renat.task.pilot.di

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier
import org.koin.dsl.module
import renat.task.pilot.screens.projects.di.ProjectsModules

inline fun <reified T> getKoinInstance(qualifier: Qualifier? = null): T {
    return object : KoinComponent {
        val value : T by inject(qualifier)
    }.value
}

fun initKoin(
    vararg applyModules: Module = arrayOf(module {})
) = startKoin {
    modules(
        *ViewModels.viewModelModules,
        *applyModules,
        ProjectsModules.module,
    )
}