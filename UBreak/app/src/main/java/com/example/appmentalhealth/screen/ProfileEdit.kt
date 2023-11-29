package com.example.appmentalhealth.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.Screen
import com.example.appmentalhealth.ui.theme.*


//data class UserData(
//    val name: String = "",
//    val email: String = "",
//    val nim: String = "",
//    val phoneNumber: String = "",
//    val profileImageUrl: String = "" // Added profile image URL field
//)
@Composable
fun Profile1Screen(
    navController: NavController
) {
    var showDialog by remember { mutableStateOf(false) }
    var frist by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier
            .padding(10.dp))

        Text(
            text = "Edit Profile",
            textAlign = TextAlign.Center,
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        Spacer(modifier = Modifier
            .padding(10.dp))

        Box(modifier = Modifier
            .clickable {
                showDialog = !showDialog
            })
        {
            // Gambar
            Image(
                painter = painterResource(id = R.drawable.gantifoto),
                contentDescription = null,
                Modifier
                    .padding(10.dp)
                    .width(81.dp)
                    .height(84.dp),
                contentScale = ContentScale.Crop
            )
        }

        Text(
            text = "Rachel Florencia",
            textAlign = TextAlign.Center,
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier
                .fillMaxWidth()
        )
        Text(
            text = "Rachelcia@student.ub.ac.id",
            textAlign = TextAlign.Center,
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier
            .padding(50.dp))

        // Label Email
        OutlinedTextField(
            value = frist,
            onValueChange = { frist = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            label = { Text("Full name") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) }
        )

        Spacer(modifier = Modifier
            .padding(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            label = { Text("Email") },
            leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) }
        )

        Spacer(modifier = Modifier
            .padding(10.dp))
        
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            label = { Text("Phone number") },
            leadingIcon = { Icon(Icons.Default.Phone, contentDescription = null) }
        )

        Spacer(
            modifier = Modifier.padding(60.dp)
        )

        // Tombol "Get Started"
        Column(modifier = Modifier
            .width(250.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(50.dp)),
        )
        {
            Button(
                onClick = {
                    navController.navigate(route = Screen.Profile.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(Green4)
            ) {
                Text(text = "Update Profile",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Thin,
                    fontSize = 16.sp,
                    color = White,)
            }

        }
        Spacer(
            modifier = Modifier.padding(20.dp)
        )
        if (showDialog) {
            Dialog(
                onDismissRequest = {
                    // Dismiss the popup when clicked outside
                    showDialog = false
                },
                properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
            ) {
                // Content of the popup
                Column(
                    modifier = Modifier
                        .width(200.dp)
                        .height(250.dp)
                        .background(color = White),
                ) {
                    Spacer(modifier = Modifier
                        .padding(20.dp))
                    Text(
                        text = "Profile Photo",
                        textAlign = TextAlign.Center,
                        fontFamily = alegreyaFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier
                        .padding(20.dp))
                    Row(Modifier
                        .fillMaxWidth()
                        .height(100.dp),
                        horizontalArrangement = Arrangement.Center
                    )
                    {
                        Box(modifier = Modifier
                            .clickable {
                                navController.navigate(route = Screen.Profile.route)
                            })
                        {
                            // Gambar
                            Image(
                                painter = painterResource(id = R.drawable.camera),
                                contentDescription = null,
                                Modifier
                                    .width(60.dp)
                                    .padding(start = 10.dp)
                                    .height(70.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                        Box(modifier = Modifier
                            .clickable {
                                navController.navigate(route = Screen.Profile.route)
                            })
                        {
                            // Gambar
                            Image(
                                painter = painterResource(id = R.drawable.gallery),
                                contentDescription = null,
                                Modifier
                                    .padding(start = 40.dp)
                                    .width(60.dp)
                                    .height(80.dp),
                                contentScale = ContentScale.Crop
                            )
                        }
                    }
                    Button(
                        onClick = {
                            // Dismiss the popup when the button is clicked
                            showDialog = false
                        },
                        modifier = Modifier
                            .height(35.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        colors = ButtonDefaults.buttonColors(Green4)
                    ) {
                        Text("Close")
                    }
                }
            }
        }
        Spacer(modifier = Modifier
            .padding(20.dp))
        }
    }

@Preview(showBackground = true)
@Composable
fun PreviewProfile1Screen() {
        Profile1Screen(
            navController = rememberNavController()
        )
}