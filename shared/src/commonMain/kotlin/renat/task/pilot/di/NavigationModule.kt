package renat.task.pilot.di

import org.koin.dsl.module
import renat.task.pilot.navigation.Navigator
import renat.task.pilot.navigation.NavigatorImpl

object NavigationModule {
    val module = module {
        single<Navigator> { NavigatorImpl() }
    }
}