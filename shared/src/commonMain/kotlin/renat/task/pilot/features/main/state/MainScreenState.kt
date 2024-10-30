package renat.task.pilot.features.main.state

import renat.task.pilot.core.base.vm.State
import renat.task.pilot.features.main.model.BottomNavigationItem

data class MainScreenState(
    val navigationItems: List<BottomNavigationItem>
): State {
    companion object {
        fun initial() = MainScreenState(
            navigationItems = listOf(
                BottomNavigationItem.ProjectsNavItem(),
                BottomNavigationItem.KanbanNavItem(),
                BottomNavigationItem.ProfileNavItem(),
            )
        )
    }
}
