package com.example.appmentalhealth.screen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.Screen
import com.example.appmentalhealth.ui.theme.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.appmentalhealth.data.UsersData
@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun ProfileScreen(
    userData: UsersData,
    navController: NavController
) {
    var userData by remember { mutableStateOf(userData) }
    val auth = FirebaseAuth.getInstance()
    val userId = auth.currentUser?.uid
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(userId) {
        userId?.let { uid ->
            FirebaseFirestore.getInstance().collection("user").document(uid)
                .get()
                .addOnSuccessListener { document ->
                    if (document != null) {
                        userData = (document.toObject(userData::class.java) ?: userData)
                        Log.d("ProfileScreen", "Data loaded: $userData")
                    } else {
                        Log.d("ProfileScreen", "No document found")
                    }
                }
                .addOnFailureListener { e ->
                    Log.d("ProfileScreen", "Error loading data", e)
                }
        } ?: Log.d("ProfileScreen", "User ID is null")
    }
    fun performPasswordReset() {
        // Implement your password reset logic here
        // If the reset is successful, set showDialog to true
        // If the reset fails, handle the error
        // For example, you can use Firebase Authentication to send a password reset email
        val auth = FirebaseAuth.getInstance()
        val userEmail = auth.currentUser?.email
        userEmail?.let { email ->
            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Password reset email sent successfully
                        showDialog = true
                    } else {
                        // Handle the error here
                        // You can log the error or show an error message
                        val exception = task.exception
                        Log.e("ProfileScreen", "Password reset failed: $exception")
                    }
                }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )

        Text(
            text = "Profile",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
//        //detail profile
        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Green4
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profiletemp), // Ganti dengan resource gambar yang benar
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(120 .dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text =  userData.fullname,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text =  userData.email,
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 14.sp
                    )
                    Text(
                        text =  userData.nim,
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 14.sp
                    )
                    Text(
                        text =  userData.phoneNumber,
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 14.sp
                    )
                }
            }
        }

        Text(
            text = "Account",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        Card(
            modifier = Modifier
                .border(1.dp, color = Color.Black)
                .width(350.dp)
                .fillMaxHeight(),
        )
        {
            Box(
                Modifier
                    .padding(20.dp)
                    .width(200.dp)
                    .clickable { navController.navigate(route = Screen.ProfileEdit.route) }
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                Modifier
                    .padding(20.dp)
                    .padding(top = 70.dp)
                    .width(200.dp)
                    .clickable { performPasswordReset() }
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.reset),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
                if (showDialog) {
                    AlertDialog(

                        onDismissRequest = {
                            showDialog = false
                        },
                        title = {
                            Text("Password Reset Link Sent")
                        },
                        text = {
                            Text("A password reset link has been sent to your email address. Please check your inbox and follow the instructions to reset your password.")
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    showDialog = false
                                }
                            ) {
                                Text("OK")

                            }
                        },
                    )
                }
            }

            Box(
                Modifier
                    .padding(20.dp)
                    .padding(top = 150.dp)
                    .width(200.dp)
                    .clickable { navController.navigate(route = Screen.Logout.route) }
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }

        }

        Text(
            text = "More",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        Card(
            modifier = Modifier
                .border(1.dp, color = Color.Black)
                .width(350.dp)
                .fillMaxHeight(),
        )
        {
            Box(
                Modifier
                    .padding(20.dp)
                    .width(200.dp)
                    .clickable { navController.navigate(route = Screen.Profile.route) }
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.help),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                Modifier
                    .padding(20.dp)
                    .padding(top = 70.dp)
                    .width(200.dp)
                    .clickable { navController.navigate(route = Screen.Profile3.route) }
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.about),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )

        Row(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = White),
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .clickable {
                        navController.navigate(route = Screen.Main.route)
                    }
            ) {
                Image(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .width(57.dp)
                        .height(80.dp),
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

            Box(
                modifier = Modifier
                    .clickable { navController.navigate(route = Screen.Conseling.route) }
            )
            {
                Image(
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .width(57.dp)
                        .height(80.dp),
                    painter = painterResource(id = R.drawable.konsel),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }


            Box(
                modifier = Modifier
                    .clickable { navController.navigate(route = Screen.Journal.route) })
            {
                Image(
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .width(57.dp)
                        .height(80.dp),
                    painter = painterResource(id = R.drawable.jurnal),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }


            Box(
                modifier = Modifier
                    .clickable { navController.navigate(route = Screen.Profile.route) })
            {
                Image(
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .width(57.dp)
                        .height(80.dp),
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.P)
@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    ProfileScreen(
        userData = UsersData(),
        navController = rememberNavController()
    )
}