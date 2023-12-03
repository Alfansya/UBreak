package com.example.appmentalhealth.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.appmentalhealth.ui.theme.Green4
import com.example.appmentalhealth.ui.theme.White
import com.example.appmentalhealth.ui.theme.alegreyaFamily

@Composable
fun Assasment1Screen(navController: NavController) {
    val options = listOf("Ever", "Never")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center, // Ratakan horizontal
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .width(50.dp)
                    .padding(end = 20.dp)
                    .offset(x = (-20).dp)
                    .clickable { navController.navigate(route = Screen.Main.route) },
                painter = painterResource(id = R.drawable.maskgroup),
                contentDescription = "image description",
                contentScale = ContentScale.Crop
            )

            Image(
                modifier = Modifier
                    .width(260.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .padding(end = 20.dp)
                    .offset(x = (-25).dp),
                painter = painterResource(id = R.drawable.progresss),
                contentDescription = "image description",
                contentScale = ContentScale.Crop

            )

        }
        Row(
            modifier = Modifier
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                text = "Have you ever had counseling or psychotherapy before?")
        }
        Spacer(modifier = Modifier
            .padding(50.dp))
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = selectedOption == option,
                        onClick = { selectedOption = option }
                    )
                    .padding(horizontal = 50.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption == option,
                    onClick = null
                )
                Text(
                    text = option,
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Thin,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }

        Spacer(modifier = Modifier
            .padding(150.dp))

        Column(modifier = Modifier
            .width(250.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(50.dp)),
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Button(
                onClick = {
                    navController.navigate(route = Screen.Assasment2.route)
                    // Add your sign-in logic here
                    // Example: Check email and password, navigate to the home screen
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(Green4)
            ) {
                Text(text = "Next",
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

@Preview(showBackground = true)
@Composable
fun PreviewAssasment1Screen() {
    Assasment1Screen( navController = rememberNavController()
    )
}
