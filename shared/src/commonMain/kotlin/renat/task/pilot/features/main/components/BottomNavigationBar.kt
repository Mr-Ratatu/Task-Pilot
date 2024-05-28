package renat.task.pilot.features.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import renat.task.pilot.core.theme.AppThemeProvider
import renat.task.pilot.features.main.model.BottomNavigationItem

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .height(54.dp)
            .background(
                AppThemeProvider.colors.cardColor,
                RoundedCornerShape(AppThemeProvider.dimens.doubleContentPadding)
            ),
        containerColor = Color.Transparent,
    ) {
        items.forEach { navItem ->
            BottomNavItem(
                isSelected = navItem.destination.fullRoute == currentRoute,
                label = navItem.name,
                icon = navItem.icon,
                onClick = {
                    navController.navigate(navItem.destination.fullRoute) {
                        popUpTo(navController.graph.startDestinationRoute ?: "")
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}

@Composable
private fun RowScope.BottomNavItem(
    isSelected: Boolean,
    label: StringResource,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    NavigationBarItem(
        modifier = Modifier.size(24.dp),
        selected = isSelected,
        onClick = onClick,
        icon = { Icon(icon, contentDescription = stringResource(label)) },
    )
}