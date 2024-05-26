package renat.task.pilot.features.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.Flow
import org.koin.compose.koinInject
import renat.task.pilot.navigation.NavGraph
import renat.task.pilot.navigation.NavigationIntent

@Composable
fun MainScreen(viewModel: MainScreenViewModel = koinInject()) {
    val navController = rememberNavController()

    NavigationEffect(
        navigationIntent = viewModel.navigationIntent,
        navHostController = navController
    )

    NavGraph(navController)
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