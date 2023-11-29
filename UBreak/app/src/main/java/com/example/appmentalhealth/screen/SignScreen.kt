package com.example.appmentalhealth.screen
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
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
import com.example.appmentalhealth.ui.theme.AppMentalHealthTheme
import com.example.appmentalhealth.ui.theme.Green4
import com.example.appmentalhealth.ui.theme.White
import com.example.appmentalhealth.ui.theme.alegreyaFamily
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignScreen(
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var fullname by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    // Firebase Auth
    val auth = FirebaseAuth.getInstance()

    // Context
    val context = LocalContext.current

    // Keyboard Controller
    val keyboardController = LocalSoftwareKeyboardController.current

    // Create a remember scroll state to control the scroll position
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
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
                text = "Register",
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 10.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 16.dp)
            )
            OutlinedTextField(
                value = fullname,
                onValueChange = { fullname = it },
                label = { Text("Fullname") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = nim,
                onValueChange = { nim = it },
                label = { Text("NIM") },
                leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Phone Number") },
                leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) },
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        // Panggil fungsi untuk mendaftar di Firebase
                        registerWithEmailAndPassword(email, password, fullname, nim, phoneNumber, auth, context)
                    }
                ),
                modifier = Modifier
                    .width(350.dp)
                    .padding(bottom = 16.dp)
            )

            Spacer(
                modifier = Modifier.padding(50.dp)
            )
            0      }


        // Grouped elements in a Column with white background
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)  // Take the full height of the screen
                .background(Color.White)
                .align(Alignment.BottomCenter),  // Align to the bottom center
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            // Button Register
            Box(
                modifier = Modifier
                    .width(320.dp)
                    .height(60.dp)
            ) {
                Button(
                    onClick = {
                        registerWithEmailAndPassword(email, password, fullname, nim, phoneNumber, auth, context)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(10.dp)),
                    colors = ButtonDefaults.buttonColors(Green4)

                ) {
                    Text(
                        text = "Register",
                        fontFamily = alegreyaFamily,
                        fontWeight = FontWeight.Thin,
                        fontSize = 16.sp,
                        color = Color.White,
                    )
                }
            }

            // Text "Do You Already Have An Account?" and "Sign In" in the same row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Do You Already Have An Account?",
                    fontFamily = alegreyaFamily,
                    modifier = Modifier
                        .padding(start = 20.dp)
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    style = TextStyle(color = Green4),
                    text = "Sign In",
                    fontFamily = alegreyaFamily,
                    modifier = Modifier
                        .clickable { navController.navigate(route = Screen.Login.route) }
                        .padding(end = 20.dp)
                )
            }
        }



    }
}

fun registerWithEmailAndPassword(
    email: String,
    password: String,
    fullname: String,
    nim: String,
    phoneNumber: String,
    auth: FirebaseAuth,
    context: Context
) {
    // Check if the email is already in use
    auth.fetchSignInMethodsForEmail(email).addOnCompleteListener { task ->
        val isNewUser = task.result?.signInMethods?.isEmpty()

        if (isNewUser == true) {
            // Email is not in use, proceed with registration
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { authTask ->
                    if (authTask.isSuccessful) {
                        // Registration successful, save user data
                        val user = auth.currentUser
                        val firestore = FirebaseFirestore.getInstance()
                        val userData = hashMapOf(
                            "email" to email,  // Include email in user data
                            "fullname" to fullname,
                            "nim" to nim,
                            "phoneNumber" to phoneNumber
                        )
                        user?.let {
                            firestore.collection("user").document(it.uid)
                                .set(userData)
                                .addOnSuccessListener {
                                    Toast.makeText(context, "Registration successful and data saved", Toast.LENGTH_SHORT).show()
                                }
                                .addOnFailureListener { e ->
                                    Toast.makeText(context, "Failed to save user data: ${e.message}", Toast.LENGTH_SHORT).show()
                                }
                        }
                    } else {
                        // Registration failed
                        Toast.makeText(context, "Registration failed: ${authTask.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            // Email is already in use
            Toast.makeText(context, "Email is already registered", Toast.LENGTH_SHORT).show()
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewSignScreen() {
    AppMentalHealthTheme() {
        SignScreen(rememberNavController())
    }
}