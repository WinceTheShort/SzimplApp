package hu.bme.aut.android.szimplapp.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screen {
    @Serializable
    data class MapScreenDestination(val title: String) : Screen

    @Serializable
    data object BarListScreenDestination : Screen

    @Serializable
    data class BarDetailScreenDestination(val barId: String) : Screen

    @Serializable
    data object DrinkListScreenDestination: Screen

    @Serializable
    data class DrinkDetailScreenDestination(val drinkId: String) : Screen

    @Serializable
    data object EventListScreenDestination: Screen

    @Serializable
    data class EventDetailScreenDestination(val eventId: String) : Screen
}
