package com.example.latestcomposeseed

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.latestcomposeseed.NavParams.LIST
import com.example.latestcomposeseed.detail.ContactDetail
import com.example.latestcomposeseed.list.ContactList


@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = LIST
) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = startDestination
    ) {
        composable(route = LIST) {
            ContactList()
        }
//        composable(
//            route = "detail/{userId}",
//            arguments = listOf(navArgument("userId") { type = NavType.StringType })
//        ) {
//            ContactDetail()
//        }
    }
}

object NavParams {
    const val LIST: String = "list"
}
