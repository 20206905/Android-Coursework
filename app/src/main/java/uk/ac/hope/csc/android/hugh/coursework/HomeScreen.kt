package uk.ac.hope.csc.android.hugh.coursework

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            onClick = {
                Log.d("ButtonClicked", "Sign up button clicked.")
                navController.navigate(route = Screen.SignUp.route)
            }
        ) {
            Text(text = stringResource(R.string.home_screen_sign_up_button_text))
        }
        Button(
            onClick = {
                Log.d("ButtonClicked", "Log In button clicked.")
                navController.navigate(route = Screen.LogIn.route)
            }
        ) {
            Text(text = stringResource(R.string.home_screen_log_in_button_text))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(
        navController = rememberNavController(),
        modifier = Modifier
    )
}