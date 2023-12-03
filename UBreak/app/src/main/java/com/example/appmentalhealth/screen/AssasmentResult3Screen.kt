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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.Screen
import com.example.appmentalhealth.ui.theme.*

@Composable
fun AssasmentResult3Screen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center, // Ratakan horizontal
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Title
        Text(
            text = "The Result Of Your \n Self-Assessment",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 10.dp)
        )
    }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(130.dp)
                .shadow(elevation = 10.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                Image(
                    modifier = Modifier
                        .width(90.dp)
                        .height(90.dp)
                        .padding(0.dp)
                        .zIndex(1f)
                        .offset(x = 5.dp, y = (5).dp),
                    painter = painterResource(id = R.drawable.green),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .padding(0.dp),
                    painter = painterResource(id = R.drawable.rectangleresult),
                    contentDescription = "image description",
                    contentScale = ContentScale.FillBounds
                )
                // Title
                Text(
                    text = "Your Mental Health",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(start = 110.dp)
                )
                Text(text = "Good Condition",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Green,
                    modifier = Modifier
                        .padding(start = 110.dp, top = 45.dp))
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(370.dp)
                .shadow(elevation = 10.dp),
            shape = RoundedCornerShape(16.dp)
        ){
            Text(
                text = "Based on the answers you provided, it seems that your current mental condition is very good and does not cause difficulties in carrying out daily activities.",
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Thin,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp)
            )
            Text(
                text = "Don't worry, we understand that every mental journey comes with its own challenges. Therefore, you can book a counselor who will assist you in improving your mental well-being. With professional support, you can undergo positive changes and discover new ways to overcome any difficulties. We believe that this journey can be a crucial step towards better mental wellness. So, feel free to take this step, and we are ready to accompany you.",
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Thin,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(start = 20.dp, top = 130.dp, end = 20.dp)
            )

        }
        Spacer(modifier = Modifier.padding(20.dp))
        Button(
            onClick = {
                navController.navigate(route = Screen.Main.route)
                // Add your sign-in logic here
                // Example: Check email and password, navigate to the home screen
            },
            modifier = Modifier
                .width(350.dp)
                .height(40.dp)
                .border(1.dp, color = Green4, RoundedCornerShape(19.dp))
                .clip(RoundedCornerShape(30.dp)),
            colors = ButtonDefaults.buttonColors(White)
        ) {
            Text(
                text = "Go To Home",
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Thin,
                fontSize = 16.sp,
                color = Green4,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAssasmentResult3Screen() {
    AssasmentResult3Screen( navController = rememberNavController()
    )
}