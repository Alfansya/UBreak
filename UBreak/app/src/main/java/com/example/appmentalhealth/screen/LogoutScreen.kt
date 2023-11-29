package com.example.appmentalhealth.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.ui.theme.Green4
import com.example.appmentalhealth.ui.theme.White
import com.example.appmentalhealth.ui.theme.alegreyaFamily
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LogoutScreen(
    navController: NavController,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    val auth = FirebaseAuth.getInstance() // Initialize Firebase Authentication

    Dialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .width(250.dp)
                .height(240.dp)
                .border(1.dp, Color.White, shape = RoundedCornerShape(15.dp)),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.dialogue),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                )
                // Content of your custom dialog
                Text(
                    text = "Oh no! You’re leaving....\n" +
                            "Are you sure?",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                )
                Column(modifier = Modifier
                    .width(210.dp)
                    .height(35.dp)
                    .clip(RoundedCornerShape(5.dp)),
                ) {
                    Button(
                        onClick = {
                            // Sign out the user
                            auth.signOut()
                            onConfirm()
                            navController.navigate("login_screen")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(1.dp),
                        colors = ButtonDefaults.buttonColors(Green4)
                    ) {
                        Text(
                            text = "Yes, Log Me Out",
                            fontFamily = alegreyaFamily,
                            fontWeight = FontWeight.Thin,
                            fontSize = 14.sp,
                            color = White,
                        )
                    }
                }
                Row(
                    Modifier
                        .padding(top = 20.dp)
                ) {
                    Button(
                        onClick = {
                            onDismiss()
                            navController.popBackStack()
                        },
                        modifier = Modifier
                            .width(210.dp)
                            .height(35.dp)
                            .padding(0.dp),
                        colors = ButtonDefaults.buttonColors(White)
                    ) {
                        Text(
                            text = "No, Take Me Back",
                            fontFamily = alegreyaFamily,
                            fontWeight = FontWeight.Thin,
                            fontSize = 14.sp,
                            color = Green4,
                        )
                    }
                }
            }
        }
    }
}


