package com.example.appmentalhealth.screen
import android.content.Context
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.Screen
import com.example.appmentalhealth.navController
import com.example.appmentalhealth.ui.theme.*
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen(
    navController: NavController
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    // Firebase Auth
    val auth = FirebaseAuth.getInstance()

    // Context
    val context = LocalContext.current

    // Keyboard Controller
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Gambar
        Image(
            painter = painterResource(id = R.drawable.group3149),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .clip(shape = MaterialTheme.shapes.medium),
            contentScale = ContentScale.FillBounds
        )

        // Title
        Text(
            text = "Sign In",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 10.dp)
        )

        // Label Email
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    // Move focus to the next field or perform login action
                }
            )
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    performLogin(auth, context, email, password)
                }
            ),
            visualTransformation = PasswordVisualTransformation()
        )
                    Spacer(
            modifier = Modifier.padding(50.dp)
        )
        // Button Sign In
        Column(modifier = Modifier
            .width(200.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(50.dp)),
            )
        {
            Button(
                onClick = {
                    performLogin(auth, context, email, password)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(Green4)
            ) {
                Text(text = "Sign In",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Thin,
                    fontSize = 16.sp,
                    color = White,)
            }
        }
        Row(Modifier
            .padding(top=5.dp)
        )
        {
            Text(
                text = "Don't have an account yet?",
                fontFamily = alegreyaFamily,
            )
            Spacer(
                modifier = Modifier.padding(5.dp)
            )
            Text(
                style = TextStyle(color = Color(0xFF43AE48)),
                text = "Register",
                fontFamily = alegreyaFamily,
                modifier = Modifier
                    .clickable { navController.navigate(route = Screen.Sign.route) }
            )
        }
    }
}

private fun performLogin(
    auth: FirebaseAuth,
    context: android.content.Context,
    email: String,
    password: String
) {
    auth.signInWithEmailAndPassword(email, password)
        .addOnCompleteListener { task ->
            if (task.isSuccessful) {
                // Login berhasil
                Toast.makeText(context, "Login success", Toast.LENGTH_SHORT).show()
                navController.navigate(route = Screen.Main.route)
            } else {
                // Login gagal
                Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    AppMentalHealthTheme() {
        LoginScreen(rememberNavController())
    }
}