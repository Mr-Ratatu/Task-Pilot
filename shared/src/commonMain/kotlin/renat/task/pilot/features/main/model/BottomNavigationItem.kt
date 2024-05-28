package renat.task.pilot.features.main.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import org.jetbrains.compose.resources.StringResource
import renat.task.pilot.navigation.Destinations
import task_pilot.shared.generated.resources.Res
import task_pilot.shared.generated.resources.nav_item_kanban
import task_pilot.shared.generated.resources.nav_item_profile
import task_pilot.shared.generated.resources.nav_item_projects

sealed interface BottomNavigationItem {
    val name: StringResource
    val destination: Destinations
    val icon: ImageVector

    data class ProjectsNavItem(
        override val name: StringResource = Res.string.nav_item_projects,
        override val destination: Destinations = Destinations.ProjectListScreen,
        override val icon: ImageVector = Icons.Default.Home
    ): BottomNavigationItem

    data class KanbanNavItem(
        override val name: StringResource = Res.string.nav_item_kanban,
        override val destination: Destinations = Destinations.KanbanBoardScreen,
        override val icon: ImageVector = Icons.AutoMirrored.Filled.List
    ): BottomNavigationItem

    data class ProfileNavItem(
        override val name: StringResource = Res.string.nav_item_profile,
        override val destination: Destinations = Destinations.NewProjectScreen,
        override val icon: ImageVector = Icons.Default.Person
    ): BottomNavigationItem
}