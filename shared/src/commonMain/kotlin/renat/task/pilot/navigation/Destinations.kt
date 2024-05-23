package renat.task.pilot.navigation

sealed class Destinations(protected val route: String, vararg arguments: Any?) {
    val fullRoute: String = if (arguments.isEmpty()) route else route.appendArguments(arguments)

    sealed class NoArgumentsDestination(route: String) : Destinations(route, null) {
        operator fun invoke() = route
    }

    data object ProjectScreen : NoArgumentsDestination(PROJECTS_SCREEN_ROUTE_DESTINATION)

    data object KanbanBoardScreen : Destinations(KANBAN_BOARD_SCREEN_ROUTE_DESTINATION) {
        private const val BOARD_ID = "board_id"

        operator fun invoke(boardId: String): String {
            return route.appendArguments(
                BOARD_ID to boardId
            )
        }
    }

    private companion object {
        const val PROJECTS_SCREEN_ROUTE_DESTINATION = "projects_screen"
        const val KANBAN_BOARD_SCREEN_ROUTE_DESTINATION = "kanban_board_screen"
    }
}

private fun String.appendArguments(vararg arguments: Pair<String, Any?>): String {
    return StringBuilder(this)
        .let { route ->
            arguments.forEach { (_, value) -> route.append("/$value") }
        }
        .toString()
}

private fun String.appendArguments(vararg arguments: Any?): String {
    return StringBuilder(this)
        .append("/")
        .append(*arguments)
        .toString()
}
