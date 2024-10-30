package renat.task.pilot.features.main

import renat.task.pilot.core.base.vm.MviViewModel
import renat.task.pilot.features.main.intent.MainScreenIntent
import renat.task.pilot.features.main.reducer.MainScreenReducer
import renat.task.pilot.features.main.state.MainScreenState
import renat.task.pilot.navigation.Navigator

class MainScreenViewModel(
    private val navigator: Navigator
): MviViewModel<MainScreenState, MainScreenIntent, MainScreenReducer>() {
    val navigationIntent = navigator.navigationIntent

    override fun initialStateValue() = MainScreenState.initial()

    override fun reduce(state: MainScreenState, reducer: MainScreenReducer): MainScreenState = state

    override fun executeIntent(intent: MainScreenIntent)  = Unit
}