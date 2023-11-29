package com.example.appmentalhealth.screen

import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.Screen
import com.example.appmentalhealth.ui.theme.*
import com.example.appmentalhealth.data.UserViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun ProfileEdit(navController: NavController, viewModel: UserViewModel) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    // Access user data from the ViewModel
    val userName = viewModel.userName.value
    val userEmail = viewModel.userEmail.value

    // Variable to track if txhe profile update was successful
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(10.dp))

        // Profile Picture
        Image(
            painter = painterResource(id = R.drawable.gantifoto), // Replace with the actual image resource
            contentDescription = null,
            Modifier
                .padding(10.dp)
                .width(81.dp)
                .height(84.dp),
            contentScale = ContentScale.Crop
        )

        // User's Name (Updated with data from the ViewModel)
        if (userName != null) {
            Text(
                text = userName, // Use the name from the ViewModel
                textAlign = TextAlign.Center,
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // User's Email (Updated with data from the ViewModel)
        if (userEmail != null) {
            Text(
                text = userEmail, // Use the email from the ViewModel
                textAlign = TextAlign.Center,
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.padding(10.dp))

        // Label Name
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            label = { Text("Full name") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) }
        )

        Spacer(modifier = Modifier.padding(10.dp))

        // Label Phone Number
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            label = { Text("Phone number") },
            leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) }
        )

        Spacer(modifier = Modifier.padding(60.dp))

        // Update Profile Button
        Button(
            onClick = {
                // Update only name and phone number in the database
                val userId = FirebaseAuth.getInstance().currentUser?.uid
                userId?.let { uid ->
                    val db = FirebaseFirestore.getInstance()
                    val userRef = db.collection("user").document(uid)

                    val updates = mapOf(
                        "fullname" to name,
                        "phoneNumber" to phone
                    )

                    userRef.update(updates)
                        .addOnSuccessListener {
                            com.example.appmentalhealth.navController.navigate(route = Screen.Profile.route)}
                        .addOnFailureListener { e ->
                            // Handle error
                            Log.e("ProfileEdit", "Error updating data", e)
                        }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(Green4)
        ) {
            Text(
                text = "Update Profile",
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Thin,
                fontSize = 16.sp,
                color = White
            )
        }
        Spacer(modifier = Modifier.padding(20.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileEdit() {
    val viewModel = viewModel<UserViewModel>()
    ProfileEdit(
        navController = rememberNavController(),
        viewModel = viewModel
    )
}
