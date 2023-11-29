package com.example.appmentalhealth.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.Screen
import com.example.appmentalhealth.ui.theme.*

@Composable
fun Profile3Screen(
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
        Spacer(modifier = Modifier
            .padding(10.dp))

        Text(
            text = "About App",
            textAlign = TextAlign.Center,
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.aboutpic),
            contentDescription = null,
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier
            .padding(5.dp))

        Text(
            text = ("The Ubreak application is an innovative platform specifically " +
                    "designed for counseling services, providing an environment that " +
                    "supports communication between counselors and counseling members. " +
                    "With its integrated chat feature, counseling members can easily c" +
                    "ommunicate with counselors to share experiences, obtain support, and " +
                    "find solutions to mental health challenges. The application not only " +
                    "provides a real-time interaction platform but also allows counseling " +
                    "members to fill out a self-assessment to measure their mental " +
                    "health. This feature offers a deeper insight into their emotional" +
                    "and psychological state, aiding counselors in formulating more " +
                    "personalized approaches. Additionally, the journailing feature " +
                    "enables users to record their emotional journeys, creating daily " +
                    "notes that assist in the reflection and self-understanding process. " +
                    "With Ubreak, this counseling application offers easier and more " +
                    "affordable access to mental health support, promoting psychological " +
                    "well-being and a better quality of life for its users."),
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(horizontal = 20.dp),
        )
        Spacer(
            modifier = Modifier.padding(20.dp)
        )
            Button(
                onClick = {
                    navController.navigate(route = Screen.Profile.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(Green4)
            ) {
                Text(
                    text = "Close",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Thin,
                    fontSize = 16.sp,
                    color = White,
                )
            }

        Spacer(
            modifier = Modifier.padding(20.dp)
        )

        }
    }

@Preview(showBackground = true)
@Composable
fun PreviewProfile3Screen() {
        Profile3Screen(
            navController = rememberNavController()
        )
}