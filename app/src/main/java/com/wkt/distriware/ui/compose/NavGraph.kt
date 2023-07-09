package com.wkt.distriware.ui.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.wkt.distriware.ui.MenuScreen
import com.wkt.distriware.ui.login.LoginScreen
import com.wkt.distriware.ui.setting.SettingScreen

@Composable
fun NavGraph(startDestination: String = NavDestinations.LoginScreen) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable(NavDestinations.LoginScreen) {

            LoginScreen(navController, onButtonClick = {
                navController.navigate(NavDestinations.SettingScreen)
            })
        }
        composable(NavDestinations.SettingScreen) {
            SettingScreen(
                onclick = { fieldName, fieldValue ->
                navController.navigate("${NavDestinations.DialogScreen}/$fieldName, $fieldValue")
            })
        }
        composable(
            "${NavDestinations.DialogScreen}/{fieldName},{fieldValue}",
            arguments = listOf(navArgument("fieldName") { type = NavType.StringType }, navArgument("fieldValue") { type = NavType.StringType })
            ) { navBackStackEntry ->
            val fieldName = navBackStackEntry.arguments?.getString("fieldName")
            val fieldValue = navBackStackEntry.arguments?.getString("fieldValue")
            DialogScreen(navController, fieldName.toString(), fieldValue.toString())
        }
        composable(NavDestinations.MenuScreen) {
            MenuScreen(navController, onButtonClick = {
                navController.navigate(NavDestinations.SettingScreen)
            })
        }
    }
}