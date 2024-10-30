package renat.task.pilot.features.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.Flow
import org.koin.compose.koinInject
import renat.task.pilot.core.view.theme.AppThemeProvider
import renat.task.pilot.features.main.components.BottomNavigationBar
import renat.task.pilot.navigation.NavGraph
import renat.task.pilot.navigation.NavigationIntent

@Composable
fun MainScreen(viewModel: MainScreenViewModel = koinInject()) {
    val state by viewModel.state.collectAsState()
    val navController = rememberNavController()

    NavigationEffect(
        navigationIntent = viewModel.navigationIntent,
        navHostController = navController
    )

    Column {
        NavGraph(
            navHostController = navController,
            modifier = Modifier.fillMaxSize().weight(1f)
        )

        BottomNavigationBar(
            modifier = Modifier.padding(AppThemeProvider.dimens.contentPadding),
            items = state.navigationItems,
            navController = navController,
        )
    }
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
