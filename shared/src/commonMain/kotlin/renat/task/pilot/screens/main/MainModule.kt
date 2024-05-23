package renat.task.pilot.screens.main

import org.koin.dsl.module

object MainModule {
    val module = module {
        factory { MainScreenViewModel(get()) }
    }
}