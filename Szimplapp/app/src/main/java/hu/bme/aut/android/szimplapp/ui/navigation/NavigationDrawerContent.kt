package hu.bme.aut.android.szimplapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Countertops
import androidx.compose.material.icons.filled.LocalBar
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material.icons.outlined.Countertops
import androidx.compose.material.icons.outlined.LocalBar
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController

data class NavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val destination: Screen
)

@Composable
fun NavigationDrawerContent(navController: NavHostController, onClick: () -> Unit) {

    val navItems = listOf(
        NavItem(
            title = "Map",
            selectedIcon = Icons.Filled.Map,
            unselectedIcon = Icons.Outlined.Map,
            destination = Screen.MapScreenDestination("Map")
        ),
        NavItem(
            title = "Bars",
            selectedIcon = Icons.Filled.Countertops,
            unselectedIcon = Icons.Outlined.Countertops,
            destination = Screen.BarListScreenDestination
        ),
        NavItem(
            title = "Drinks",
            selectedIcon = Icons.Filled.LocalBar,
            unselectedIcon = Icons.Outlined.LocalBar,
            destination = Screen.DrinkListScreenDestination
        ),
        NavItem(
            title = "Events",
            selectedIcon = Icons.Filled.CalendarMonth,
            unselectedIcon = Icons.Outlined.CalendarMonth,
            destination = Screen.EventListScreenDestination
        )
    )

    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }
    ModalDrawerSheet {
        navItems.forEachIndexed { index, item ->
            NavigationDrawerItem(
                label = { Text(text = item.title) },
                selected = index == selectedItemIndex,
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(item.destination)
                    onClick()
                },
                icon = {
                    Icon(
                        imageVector = if (index == selectedItemIndex) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = item.title
                    )
                },
                modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
            )
        }

    }
}