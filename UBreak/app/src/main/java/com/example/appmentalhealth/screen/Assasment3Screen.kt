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
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.Screen
import com.example.appmentalhealth.ui.theme.Green4
import com.example.appmentalhealth.ui.theme.White
import com.example.appmentalhealth.ui.theme.alegreyaFamily

@Composable
fun Assasment3Screen(navController: NavController) {
    val options = listOf("Never", "A year ago", "3 months ago", "2 weeks ago", "3 days ago", "Yesterday")
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

            Box(
                modifier = Modifier
                    .width(260.dp)
                    .padding(end = 20.dp)
                    .offset(x = (-25).dp)
            ) {
                Image(
                    modifier = Modifier
                        .width(260.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .zIndex(1f)
                        .offset(x = 20.dp),
                    painter = painterResource(id = R.drawable.progressfull),
                    contentDescription = "image description",
                    contentScale = ContentScale.Crop
                )

                Image(
                    modifier = Modifier
                        .width(260.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .offset(x = 20.dp),
                    painter = painterResource(id = R.drawable.progresss),
                    contentDescription = "image description",
                    contentScale = ContentScale.Crop
                )
            }
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
                text = "when was the last time you thought about ending your life?")
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
                        onClick = { selectedOption = option}
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

        Spacer(
            modifier = Modifier.padding(40.dp)
        )

        Column(modifier = Modifier
            .width(250.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(50.dp)),
        )
        {
            Button(
                onClick = {
                    when (selectedOption) {
                        "Never", "A year ago" -> {
                            navController.navigate(route = Screen.AssasmentResult3.route)
                        }
                        "3 months ago", "2 weeks ago" -> {
                            navController.navigate(route = Screen.AssasmentResult.route)
                        }
                        "3 days ago", "Yesterday" -> {
                            navController.navigate(route = Screen.AssasmentResult2.route)
                        }
                        else -> {
                            navController.navigate(route = Screen.Assasment3.route)
                        }
                    }
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
fun PreviewAssasment3Screen() {
    Assasment3Screen( navController = rememberNavController()
    )
}
