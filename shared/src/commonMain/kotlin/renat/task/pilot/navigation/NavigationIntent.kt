package renat.task.pilot.navigation

sealed interface NavigationIntent {
    data class NavigateTo(
        val route: String,
        val popUpTo: String? = null,
        val isInclusive: Boolean = false,
        val isSingleTop: Boolean = false
    ) : NavigationIntent

    data class PopBackStack(
        val route: String? = null,
        val isInclusive: Boolean = false,
    ) : NavigationIntent
}