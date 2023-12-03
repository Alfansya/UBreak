package com.example.appmentalhealth.screen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.ui.theme.AppMentalHealthTheme
import com.example.appmentalhealth.ui.theme.Green4
import com.google.firebase.auth.FirebaseAuth

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ForgotScreen(
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(contentAlignment = Alignment.Center) {
            // Base Image
            Image(
                painter = painterResource(id = R.drawable.basewave), // Replace with your base image resource
                contentDescription = "Base Image",
                modifier = Modifier.align(Alignment.Center)
                    .fillMaxWidth()
                    .height(350.dp)
                    .clip(shape = MaterialTheme.shapes.medium),
                contentScale = ContentScale.FillBounds
            )

            // Overlay Image
            Image(
                painter = painterResource(id = R.drawable.title), // Replace with your overlay image resource
                contentDescription = "Overlay Image",
                modifier = Modifier.align(Alignment.Center)
                    .width(285.dp)
                    .height(189 .dp)
                    .clip(shape = MaterialTheme.shapes.medium),
                contentScale = ContentScale.FillBounds
            )
        }

        // Title
        Text(
            text = "Forgot Password",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )

        // Email TextField
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.width(250.dp),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Send Button
        Button(
            onClick = {
                keyboardController?.hide()
                if (email.isNotEmpty()) {
                    auth.sendPasswordResetEmail(email).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(context, "Reset link sent to your email", Toast.LENGTH_LONG).show()
                        } else {
                            Toast.makeText(context, "Failed to send reset email", Toast.LENGTH_LONG).show()
                        }
                    }
                } else {
                    Toast.makeText(context, "Please enter your email", Toast.LENGTH_LONG).show()
                }
            },
            modifier = Modifier
                .width(250.dp)
                .height(48.dp)
                .clip(RoundedCornerShape(8.dp)),
            colors = ButtonDefaults.buttonColors(backgroundColor = Green4)
        ) {
            Text("Send", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewForgotScreen() {
    AppMentalHealthTheme {
        ForgotScreen(rememberNavController())
    }
}
