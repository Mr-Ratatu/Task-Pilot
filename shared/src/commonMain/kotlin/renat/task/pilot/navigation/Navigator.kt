package renat.task.pilot.navigation

import kotlinx.coroutines.flow.Flow

interface Navigator {
    val navigationIntent: Flow<NavigationIntent>

    suspend fun navigateTo(
        route: Destinations,
        popUpTo: String? = null,
        isInclusive: Boolean = false,
        isSingleTop: Boolean = false,
    )

    suspend fun popBackStack(
        route: Destinations? = null,
        isInclusive: Boolean = false,
    )

    fun tryNavigateTo(
        route: Destinations,
        popUpTo: String? = null,
        isInclusive: Boolean = false,
        isSingleTop: Boolean = false,
    )

    fun tryPopBackStack(
        route: Destinations? = null,
        isInclusive: Boolean = false,
    )
}