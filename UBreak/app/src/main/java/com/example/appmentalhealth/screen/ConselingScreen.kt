package com.example.appmentalhealth.screen

import androidx.compose.foundation.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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

@Composable
fun ConselingScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Gambar
        Image(
            painter = painterResource(id = R.drawable.interviewpana1),
            alignment = Alignment.Center,
            contentDescription = null,
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = White)
                .clip(RoundedCornerShape(25.dp)),
            contentScale = ContentScale.Crop
        )
            // Title
            Text(
                text =  "Please schedule your counseling session now. Counseling is a planned meeting with the goal of providing emotional support, guidance, or problem-solving. By scheduling counseling now, you can ensure that the time is tailored to your needs and availability, allowing you to take positive steps in supporting your well-being and personal growth. Proactively planning a counseling session also provides an opportunity to focus on specific aspects you want to explore or address, enhancing the effectiveness and meaningfulness of the counseling experience.",
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(20.dp)
            )
        Spacer(modifier = Modifier.padding(10.dp))

        Column(modifier = Modifier
            .width(250.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(50.dp)),
        )
        {
            Button(
                onClick = {
                    navController.navigate(route = Screen.Conseling2.route)
                    // Add your sign-in logic here
                    // Example: Check email and password, navigate to the home screen
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(Green4)
            ) {
                Text(text = "Schedule Now",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = White,)
            }

        }
        Spacer(
            modifier = Modifier.padding(5.dp)
        )

        Column(modifier = Modifier
            .width(250.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(50.dp)),
        )
        {
            Button(
                onClick = {
                    navController.navigate(route = Screen.Conseling4.route)
                    // Add your sign-in logic here
                    // Example: Check email and password, navigate to the home screen
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(Color.LightGray)
            ) {
                Text(text = "Already Scheduled",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                )
            }

        }
        Spacer(
            modifier = Modifier.padding(10.dp)
        )

        }
    }

@Preview(showBackground = true)
@Composable
fun PreviewConselingScreen() {
        ConselingScreen(
            navController = rememberNavController()
        )
}