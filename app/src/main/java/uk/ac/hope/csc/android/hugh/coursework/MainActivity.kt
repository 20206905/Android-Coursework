package uk.ac.hope.csc.android.hugh.coursework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uk.ac.hope.csc.android.hugh.coursework.ui.theme.CourseworkTheme

class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseworkTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}