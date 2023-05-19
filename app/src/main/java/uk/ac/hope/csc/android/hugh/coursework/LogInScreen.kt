package uk.ac.hope.csc.android.hugh.coursework

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun LogInScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    data class UserLogIn(val email: String, val password: String)

    Column(
        modifier = Modifier
            .padding(40.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        EditTextField(
            label = R.string.log_in_screen_email_label,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            value = emailInput,
            onValueChange = { emailInput = it }
        )
        Spacer(modifier = Modifier.size(32.dp))

        EditTextField(
            label = R.string.log_in_screen_password_label,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            value = passwordInput,
            onValueChange = { passwordInput = it }
        )
        Spacer(modifier = Modifier.size(64.dp))

        Button(
            onClick = {
                Log.d("ButtonClicked", emailInput)
                Log.d("ButtonClicked", passwordInput)

                navController.navigate(route = Screen.Home.route)

                val userLogIn = UserLogIn(emailInput, passwordInput)

                val userId = "-NVmNRcU_Xh_yK_ltOli"
                val myLogInRef = database.getReference("users")


                myLogInRef.child(userId).get().addOnSuccessListener {
                    Log.i("firebase", "Got value ${it.value}")
                }.addOnFailureListener{
                    Log.e("firebase", "Error getting data", it)
                }
            }
        ) {
            Text(text = stringResource(R.string.log_in_screen_log_in_button_text))
        }
    }
}







@Composable
@Preview(showBackground = true)
fun LogInScreenPreview() {
    LogInScreen(
        navController = rememberNavController(),
        modifier = Modifier
    )
}