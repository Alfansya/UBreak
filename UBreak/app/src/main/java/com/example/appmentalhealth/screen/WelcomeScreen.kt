// welcome screen
package com.example.appmentalhealth.screen

import androidx.compose.runtime.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.Screen
import com.example.appmentalhealth.ui.theme.*
import com.google.firebase.auth.FirebaseAuth

@Composable
fun WelcomeScreen(
    navController: NavController
)
 {
    // Check if the user is already logged in using Firebase Authentication
    val auth = FirebaseAuth.getInstance()
    val currentUser = auth.currentUser

    // If the user is already logged in, navigate to the main screen
    if (currentUser != null) {
        navController.navigate(Screen.Main.route)
        return
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .fillMaxHeight()
            .background(color = Green7),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .background(color = White),
            contentAlignment = Alignment.Center) {
            // Base Image
            Image(
                painter = painterResource(id = R.drawable.starimg),
                contentDescription = "Base Image",
                modifier = Modifier.align(Alignment.TopCenter)
                    .clip(shape = MaterialTheme.shapes.medium)
            )

            // Overlay Image
            Image(
                painter = painterResource(id = R.drawable.wavebottom),
                contentDescription = "Overlay Image",
                modifier = Modifier
                    .clip(shape = MaterialTheme.shapes.medium)
                    .align(Alignment.BottomCenter)
            )
        }

        // Title
        Text(
            text = "Harmonize Your Thoughts \n" +
                    "Elevate Your Grades",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            color = White,
            textAlign = TextAlign.Center,
        )

        // Deskripsi
        Text(
            text = "The best self-love, the finest peace, the powerful equilibrium.",
            textAlign = TextAlign.Center,
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Thin,
            fontSize = 22.sp,
            color = White,
            modifier = Modifier.padding(
                top = 22.dp,
                bottom = 22.dp
            )

        )


        // Tombol "Get Started"
        Column(modifier = Modifier
            .width(320.dp)
            .height(60.dp)
            .clip(RoundedCornerShape(15.dp)),
            verticalArrangement = Arrangement.Bottom
        )
        {
            Button(
                onClick = {
                    navController.navigate(route = Screen.Login.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(Green4)

            ) {
                Text(text = "Get Started",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Thin,
                    fontSize = 24.sp,
                    color = White,)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWelcomeScreen() {
    WelcomeScreen(
        navController = rememberNavController()
    )
}