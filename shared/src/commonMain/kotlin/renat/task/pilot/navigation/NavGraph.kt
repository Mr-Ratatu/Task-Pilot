package renat.task.pilot.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import renat.task.pilot.navigation.Destinations.*
import renat.task.pilot.features.board.BoardScreen
import renat.task.pilot.features.new_project.presentation.NewProjectScreen
import renat.task.pilot.features.projects.presentation.ProjectScreen

@Composable
fun NavGraph(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = ProjectListScreen.fullRoute
    ) {
        composable(route = ProjectListScreen.fullRoute) { ProjectScreen() }
        composable(route = NewProjectScreen.fullRoute) { NewProjectScreen() }
        composable(route = KanbanBoardScreen.fullRoute) { BoardScreen() }
    }
}
