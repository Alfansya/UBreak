package com.example.appmentalhealth.screen

import androidx.compose.foundation.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.Screen
import com.example.appmentalhealth.ui.theme.*

@Composable
fun AssasmentScreen(
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
        Image(
            modifier = Modifier
                .width(50.dp)
                .padding(end = 20.dp, top = 20.dp)
                .offset(x = (-150).dp)
                .clickable { navController.navigate(route = Screen.Main.route) },
            painter = painterResource(id = R.drawable.back),
            contentDescription = "image description",
            contentScale = ContentScale.Crop
        )
        // Gambar
        Image(
            painter = painterResource(id = R.drawable.assasmenticon),
            alignment = Alignment.Center,
            contentDescription = null,
            modifier = Modifier
                .padding(top = 70.dp)
                .width(118.dp)
                .height(118.dp)
                .background(color = White)
                .clip(RoundedCornerShape(25.dp)),
            contentScale = ContentScale.Crop
        )
            // Title
            Text(
                text = "Self-Assessment",
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 10.dp)
            )

            // Deskripsi
            Text(
                text = "Please take the time to complete a self-assessment now. Self-assessment is a personal reflection process that can help you gain a better understanding of yourself, review achievements, identify areas for development, and evaluate feelings and life goals. By filling out a self-assessment now, you give yourself the opportunity to contemplate deeply on various aspects of your personal life, including physical, mental, and emotional well-being. This process can serve as a valuable foundation for personal planning and self-development, enabling you to take steps toward positive growth and achieving better goals.",
                textAlign = TextAlign.Justify,
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Thin,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 20.dp, bottom = 200.dp, start = 10.dp, end = 10.dp)

            )

            Column(modifier = Modifier
                .width(250.dp)
                .height(40.dp)
                .offset(y = (-20).dp)
                .clip(RoundedCornerShape(50.dp)),
                )
            {
                Button(
                    onClick = {
                    navController.navigate(route = Screen.Assasment1.route)
                    // Add your sign-in logic here
                    // Example: Check email and password, navigate to the home screen
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    colors = ButtonDefaults.buttonColors(Green4)
                ) {
                    Text(text = "Mulai Tes",
                        fontFamily = alegreyaFamily,
                        fontWeight = FontWeight.Thin,
                        fontSize = 16.sp,
                        color = White,)
                }
            }
        Spacer(
            modifier = Modifier.padding(20.dp)
        )
        }
    }

fun onSelectedChange(any: Any) {

}

@Preview(showBackground = true)
@Composable
fun PreviewAssasmentScreen() {
        AssasmentScreen( navController = rememberNavController()
        )
}