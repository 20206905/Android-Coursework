package uk.ac.hope.csc.android.hugh.coursework

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.SignUp.route
        ) {
            SignUpScreen(navController)
        }
        composable(
            route = Screen.LogIn.route
        ) {
            LogInScreen(navController)
        }
    }
}