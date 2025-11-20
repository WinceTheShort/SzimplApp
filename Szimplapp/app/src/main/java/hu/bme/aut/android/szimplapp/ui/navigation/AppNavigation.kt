package hu.bme.aut.android.szimplapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import hu.bme.aut.android.szimplapp.ui.screen.bar_detail_screen.BarDetailScreen
import hu.bme.aut.android.szimplapp.ui.screen.bar_list_screen.BarListScreen
import hu.bme.aut.android.szimplapp.ui.screen.drink_detail_screen.DrinkDetailScreen
import hu.bme.aut.android.szimplapp.ui.screen.drink_list_screen.DrinkListScreen
import hu.bme.aut.android.szimplapp.ui.screen.event_detail_screen.EventDetailScreen
import hu.bme.aut.android.szimplapp.ui.screen.event_list_screen.EventListScreen
import hu.bme.aut.android.szimplapp.ui.screen.map_screen.MapScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.MapScreenDestination("Home")
    ) {
        composable<Screen.MapScreenDestination> {
            val args = it.toRoute<Screen.MapScreenDestination>()
            MapScreen(args.title)
        }

        composable<Screen.BarListScreenDestination> {
            BarListScreen()
        }

        composable<Screen.BarDetailScreenDestination> {
            val args = it.toRoute<Screen.BarDetailScreenDestination>()
            BarDetailScreen(args.barId)
        }

        composable<Screen.DrinkListScreenDestination>{
            DrinkListScreen()
        }

        composable<Screen.DrinkDetailScreenDestination> {
            val args = it.toRoute<Screen.DrinkDetailScreenDestination>()
            DrinkDetailScreen(args.drinkId)
        }

        composable<Screen.EventListScreenDestination>{
            EventListScreen()
        }

        composable<Screen.EventDetailScreenDestination>{
            val args = it.toRoute<Screen.EventDetailScreenDestination>()
            EventDetailScreen(args.eventId)
        }

    }
}