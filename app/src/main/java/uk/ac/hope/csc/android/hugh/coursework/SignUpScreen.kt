package uk.ac.hope.csc.android.hugh.coursework

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


@Composable
fun SignUpScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var nameInput by remember { mutableStateOf("") }
    var emailInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }

    data class User(val name: String, val email: String, val password: String)

    Column(
        modifier = Modifier
            .padding(40.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        EditTextField(
            label = R.string.sign_up_screen_name_label,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            value = nameInput,
            onValueChange = { nameInput = it }
        )
        Spacer(modifier = Modifier.size(32.dp))

        EditTextField(
            label = R.string.sign_up_screen_email_label,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            value = emailInput,
            onValueChange = { emailInput = it }
        )
        Spacer(modifier = Modifier.size(32.dp))

        EditTextField(
            label = R.string.sign_up_screen_password_label,
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
                Log.d("ButtonClicked", nameInput)
                Log.d("ButtonClicked", emailInput)
                Log.d("ButtonClicked", passwordInput)

                navController.navigate(route = Screen.Home.route)

                val user = User(nameInput, emailInput, passwordInput)
                myRef.setValue(user)
            }
        ) {
            Text(text = stringResource(R.string.sign_up_screen_sign_up_button_text))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(stringResource(label)) },
        singleLine = true,
        keyboardOptions = keyboardOptions,
        modifier = Modifier.fillMaxWidth()
    )
}


val database =
    Firebase.database("https://coursework-ce33e-default-rtdb.europe-west1.firebasedatabase.app/")
val myRef = database.getReference("users").push()


@Composable
@Preview(showBackground = true)
fun SignUpScreenPreview() {
    SignUpScreen(
        navController = rememberNavController(),
        modifier = Modifier
    )
}