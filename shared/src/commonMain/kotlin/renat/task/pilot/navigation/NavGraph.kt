package renat.task.pilot.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import renat.task.pilot.navigation.Destinations.*
import renat.task.pilot.screens.board.BoardScreen
import renat.task.pilot.screens.new_project.presentation.NewProjectScreen
import renat.task.pilot.screens.projects.presentation.ProjectScreen

@Composable
fun NavGraph(navHostController: NavHostController) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navHostController,
        startDestination = ProjectListScreen.fullRoute
    ) {
        composable(route = ProjectListScreen.fullRoute) { ProjectScreen() }
        composable(route = NewProjectScreen.fullRoute) { NewProjectScreen() }
        composable(route = KanbanBoardScreen.fullRoute) { BoardScreen() }
    }
}
