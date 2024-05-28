package renat.task.pilot.features.main.di

import org.koin.dsl.module
import renat.task.pilot.features.main.MainScreenViewModel

object MainModule {
    val module = module {
        factory { MainScreenViewModel(get()) }
    }
}