package renat.task.pilot.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

class NavigatorImpl : Navigator {
    private val _navigationIntent = Channel<NavigationIntent>()
    override val navigationIntent: Flow<NavigationIntent> = _navigationIntent.receiveAsFlow()

    override suspend fun navigateTo(
        route: Destinations,
        popUpTo: String?,
        isInclusive: Boolean,
        isSingleTop: Boolean
    ) {
        _navigationIntent.send(
            NavigationIntent.NavigateTo(
                route = route.fullRoute,
                popUpTo = popUpTo,
                isInclusive = isInclusive,
                isSingleTop = isSingleTop
            )
        )
    }

    override suspend fun popBackStack(route: Destinations?, isInclusive: Boolean) {
        _navigationIntent.send(
            NavigationIntent.PopBackStack(
                route = route?.fullRoute,
                isInclusive = isInclusive,
            )
        )
    }

    override fun tryNavigateTo(
        route: Destinations,
        popUpTo: String?,
        isInclusive: Boolean,
        isSingleTop: Boolean
    ) {
        _navigationIntent.trySend(
            NavigationIntent.NavigateTo(
                route = route.fullRoute,
                popUpTo = popUpTo,
                isInclusive = isInclusive,
                isSingleTop = isSingleTop
            )
        )
    }

    override fun tryPopBackStack(route: Destinations?, isInclusive: Boolean) {
        _navigationIntent.trySend(
            NavigationIntent.PopBackStack(
                route = route?.fullRoute,
                isInclusive = isInclusive,
            )
        )
    }
}