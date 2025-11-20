package hu.bme.aut.android.szimplapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppScreen() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    ModalNavigationDrawer(
        drawerContent = { /*Todo*/ },
        drawerState = drawerState

    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Szimplapp") },
                    navigationIcon = {
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu")
                        }
                    },
                )
            },
        ) { }
    }
}