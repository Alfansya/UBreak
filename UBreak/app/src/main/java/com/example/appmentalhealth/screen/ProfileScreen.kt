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
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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

data class AccItem(val icon: Int, val title: String, val desc: String, val onClick: () -> Unit)
data class MoreItem(val icon: Int, val title: String, val desc: String, val onClick: () -> Unit)
@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun ProfileScreen(
    userData: UsersData,
    navController: NavController
) {
    var userData by remember { mutableStateOf(userData) }
    val auth = FirebaseAuth.getInstance()
    val userId = auth.currentUser?.uid
    val accItems = listOf(
        AccItem(icon = R.drawable.icnedit, title = "Edit Profile", desc = "Edit your Account here") {
            navController.navigate(route = Screen.ProfileEdit.route)
        },
        AccItem(icon = R.drawable.icnreset, title = "Reset Password", desc = "Reset your password here") {
            navController.navigate(route = Screen.Forgot.route)
        },
        AccItem(icon = R.drawable.icnlogout, title = "Log Out", desc = "Log out from your account here") {
            navController.navigate(route = Screen.Logout.route)
        }
    )
    val moreItems = listOf(
        MoreItem(icon = R.drawable.icnhelp, title = "Help & Support", desc = "Get assistance and find answers to your questions") {
            navController.navigate(route = Screen.Profile.route)
        },
        MoreItem(icon = R.drawable.icnabout, title = "About App", desc = "Learn more about the app and its features") {
            navController.navigate(route = Screen.Profile3.route)
        }
    )

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
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
                .padding(start = 16.dp, end = 16.dp, top = 5.dp)
                .fillMaxWidth()
                .wrapContentHeight()
                .offset(y = (-15).dp),
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
                    painter = painterResource(id = R.drawable.profiletemp),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.White, CircleShape)
                )
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = userData.fullname,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                    Text(
                        text = userData.email,
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 14.sp
                    )
                    Text(
                        text = userData.nim,
                        color = Color.White.copy(alpha = 0.7f),
                        fontSize = 14.sp
                    )
                    Text(
                        text = userData.phoneNumber,
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
                .offset(y = (-20).dp)
        )
            Box(
                Modifier
                    .padding(20.dp)
                    .width(350.dp)
                    .offset(y = (-20).dp)
                    .clickable { navController.navigate(route = Screen.ProfileEdit.route) }
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    // Loop through each menu item and create a row
                    accItems.forEach { menuItem ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(y=(-40).dp)
                                .clickable(onClick = menuItem.onClick)
                                .padding(vertical = 8.dp)
                                .shadow(elevation = 10.dp, shape = RoundedCornerShape(10.dp), clip = true),
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = menuItem.icon),
                                    contentDescription = menuItem.title,
                                    modifier = Modifier.size(45.dp),
                                    tint = Color.Unspecified
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .align(Alignment.CenterVertically)
                                ) {
                                    Text(
                                        text = menuItem.title,
                                        fontSize = 18.sp,
                                        fontFamily = alegreyaFamily,
                                        fontWeight = FontWeight.Medium
                                    )
                                    Text(
                                        text = menuItem.desc,
                                        fontSize = 14.sp,
                                        fontFamily = alegreyaFamily,
                                        fontWeight = FontWeight.Light,
                                        color = Color.Gray
                                    )
                                }
                                Icon(
                                    painter = painterResource(R.drawable.icnarrow),
                                    contentDescription = "Go",
                                    modifier = Modifier.size(24.dp),
                                    tint = Color.Unspecified
                                )
                            }
                        }
                    }
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
                .offset(y = (-90).dp)
        )
            Box(
                Modifier
                    .padding(top = 20.dp, start = 20.dp, end = 20.dp)
                    .width(380.dp)
                    .clickable { navController.navigate(route = Screen.ProfileEdit.route) }
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y= (-80).dp)
                ) {
                    // Loop through each menu item and create a row
                    moreItems.forEach { menuItem ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .offset(y=(-50).dp)
                                .clickable(onClick = menuItem.onClick)
                                .padding(vertical = 8.dp)
                                .shadow(elevation = 10.dp, shape = RoundedCornerShape(10.dp), clip = true),
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = menuItem.icon),
                                    contentDescription = menuItem.title,
                                    modifier = Modifier.size(45.dp),
                                    tint = Color.Unspecified
                                )
                                Spacer(modifier = Modifier.width(16.dp))
                                Column(
                                    modifier = Modifier
                                        .weight(1f)
                                        .align(Alignment.CenterVertically)
                                ) {
                                    Text(
                                        text = menuItem.title,
                                        fontSize = 18.sp,
                                        fontFamily = alegreyaFamily,
                                        fontWeight = FontWeight.Medium
                                    )
                                    Text(
                                        text = menuItem.desc,
                                        fontSize = 14.sp,
                                        fontFamily = alegreyaFamily,
                                        fontWeight = FontWeight.Light,
                                        color = Color.Gray
                                    )
                                }
                                Icon(
                                    painter = painterResource(R.drawable.icnarrow),
                                    contentDescription = "Go",
                                    modifier = Modifier.size(24.dp),
                                    tint = Color.Unspecified
                                )
                            }
                        }
                    }
                }
            }
    }

    // Bottom Navigation Bar
    BottomBarRow(
        items = listOf(
            BottomNavItem(route = Screen.Main.route, iconResId = R.drawable.home_new),
            BottomNavItem(route = Screen.Conseling.route, iconResId = R.drawable.konsel_new),
            BottomNavItem(route = Screen.Journal.route, iconResId = R.drawable.jurnal_new),
            BottomNavItem(route = Screen.Profile.route, iconResId = R.drawable.profile_new)
        ),
        navController = navController
    )
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
