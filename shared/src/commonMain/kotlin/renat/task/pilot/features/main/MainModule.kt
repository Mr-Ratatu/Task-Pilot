package renat.task.pilot.features.main

import org.koin.dsl.module

object MainModule {
    val module = module {
        factory { MainScreenViewModel(get()) }
    }
}