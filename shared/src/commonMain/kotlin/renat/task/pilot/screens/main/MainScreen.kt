package renat.task.pilot.screens.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.Flow
import renat.task.pilot.navigation.NavHostScreens
import renat.task.pilot.navigation.NavigationIntent

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {
    val navController = rememberNavController()

    NavigationEffect(
        navigationIntent = viewModel.navigationIntent,
        navHostController = navController
    )

    NavHostScreens(navController)
}

@Composable
fun NavigationEffect(
    navigationIntent: Flow<NavigationIntent>,
    navHostController: NavHostController,
) {
    LaunchedEffect(navHostController, navigationIntent) {
        navigationIntent.collect { intent ->
            when (intent) {
                is NavigationIntent.NavigateTo -> navHostController.navigate(intent.route) {
                    launchSingleTop = intent.isSingleTop
                    intent.popUpTo?.let { route ->
                        popUpTo(route) { inclusive = intent.isInclusive }
                    }
                }

                is NavigationIntent.PopBackStack -> {
                    intent.route?.also { route ->
                        navHostController.popBackStack(route, intent.isInclusive)
                    } ?: navHostController.popBackStack()
                }
            }
        }
    }
}
