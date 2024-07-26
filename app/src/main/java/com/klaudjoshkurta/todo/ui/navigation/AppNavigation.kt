package com.klaudjoshkurta.todo.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.klaudjoshkurta.todo.ui.screens.EntryScreen
import com.klaudjoshkurta.todo.ui.screens.HomeScreen

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Entry : Screen("entry")
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: Screen = Screen.Home
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination.route
    ) {

        /** Home screen */
        composable(route = Screen.Home.route) {
            HomeScreen(
                navigateToEntryScreen = { navController.navigate(Screen.Entry.route) }
            )
        }

        /** Entry screen */
        composable(route = Screen.Entry.route) {
            EntryScreen(
                onCancel = {
                    navController.popBackStack()
                    navController.navigateUp()
                }
            )
        }

    }
}