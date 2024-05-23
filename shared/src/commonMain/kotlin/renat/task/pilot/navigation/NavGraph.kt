package renat.task.pilot.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import renat.task.pilot.navigation.Destinations.*
import renat.task.pilot.screens.board.BoardScreen
import renat.task.pilot.screens.projects.presentation.ProjectScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = ProjectScreen.fullRoute
    ) {
        composable(route = ProjectScreen.fullRoute) { ProjectScreen() }
        composable(route = KanbanBoardScreen.fullRoute) { BoardScreen() }
    }
}
