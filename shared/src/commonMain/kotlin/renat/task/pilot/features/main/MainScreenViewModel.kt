package renat.task.pilot.features.main

import androidx.lifecycle.ViewModel
import renat.task.pilot.navigation.Navigator

class MainScreenViewModel(navigator: Navigator): ViewModel() {
    val navigationIntent = navigator.navigationIntent
}