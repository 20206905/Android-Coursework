package uk.ac.hope.csc.android.hugh.coursework

sealed class Screen(val route: String) {
    object Home: Screen(route = "home_screen")
    object SignUp: Screen(route = "sign_up_screen")
    object LogIn: Screen(route = "log_in_screen")
}
