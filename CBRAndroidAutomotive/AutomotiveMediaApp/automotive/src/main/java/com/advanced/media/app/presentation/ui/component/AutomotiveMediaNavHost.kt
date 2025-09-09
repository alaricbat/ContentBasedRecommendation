package com.advanced.media.app.presentation.ui.component

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.advanced.media.app.presentation.ui.screen.MainScreen
import com.advanced.media.app.presentation.ui.screen.Screen

@Composable
fun AutomotiveMediaNavHost(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MAIN.name,
        enterTransition = {slideIntoContainer(towards = AnimatedContentTransitionScope.SlideDirection.Up)},
        exitTransition = {slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.Down)}
    ) {
        composable(route = Screen.MAIN.name) {
            MainScreen(
                onItemSelected = {
                    id -> navController.navigate(Screen.DETAIL.name)
                }
            )
        }
        composable(route = Screen.DETAIL.name) {

        }
        composable(route = Screen.PLAYER.name) {

        }
    }
}