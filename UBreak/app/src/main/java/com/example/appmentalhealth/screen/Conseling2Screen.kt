package com.example.appmentalhealth.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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

data class Counselor(val icon: Int, val title: String, val desc: String, val onClick: () -> Unit)
@Composable
fun Conseling2Screen(
    navController: NavController
) {
    val counselor = listOf(
        Counselor(icon = R.drawable.image8, title = "Dr. Imran Syahir", desc = "Psychologists") {
            navController.navigate(route = Screen.Conseling3.route)
        }
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(color = White),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(
            modifier = Modifier
                .padding(20.dp)
        )
        // Gambar
        Image(
            painter = painterResource(id = R.drawable.iconmenu),
            contentDescription = null,
            Modifier
                .padding(10.dp)
                .width(78.dp)
                .height(52.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Choose a Counselor",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        Row(
            modifier = Modifier
                .padding(20.dp)
                .width(350.dp)
                .offset(y = (-20).dp)
                .clickable { navController.navigate(route = Screen.ProfileEdit.route) }
        )
        {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                // Loop through each menu item and create a row
                counselor.forEach { menuItem ->
                    Card(
                        modifier = Modifier
                            .width(170.dp)
                            .height(200.dp)
                            .clickable(onClick = menuItem.onClick)
                            .padding(vertical = 8.dp)
                            .shadow(
                                elevation = 10.dp,
                                shape = RoundedCornerShape(10.dp),
                                clip = true
                            ),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = menuItem.icon),
                                contentDescription = menuItem.title,
                                modifier = Modifier
                                    .size(70.dp)
                                    .padding(0.dp)
                                    .clip(shape = RoundedCornerShape(100.dp)),
                                tint = Color.Unspecified
                            )
                            Spacer(modifier = Modifier.height(10.dp))
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
                            Spacer(modifier = Modifier.weight(1f))
                            Button(
                                onClick = {
                                    navController.navigate(route = Screen.Conseling3.route)
                                },
                                modifier = Modifier
                                    .width(130.dp)
                                    .height(40.dp)
                                    .padding(1.dp)
                                    .clip(shape = RoundedCornerShape(20.dp)),
                                colors = ButtonDefaults.buttonColors(Green4)
                            ) {
                                Text(
                                    text = "Choose",
                                    modifier = Modifier,
                                    fontSize = 14.sp,
                                    fontFamily = alegreyaFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                )
                            }
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 5.dp)
            ) {
                counselor.forEach { menuItem ->
                    Card(
                        modifier = Modifier
                            .width(170.dp)
                            .height(200.dp)
                            .clickable(onClick = menuItem.onClick)
                            .padding(vertical = 8.dp)
                            .shadow(
                                elevation = 10.dp,
                                shape = RoundedCornerShape(10.dp),
                                clip = true
                            ),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = menuItem.icon),
                                contentDescription = menuItem.title,
                                modifier = Modifier
                                    .size(70.dp)
                                    .padding(0.dp)
                                    .clip(shape = RoundedCornerShape(100.dp)),
                                tint = Color.Unspecified
                            )
                            Spacer(modifier = Modifier.height(10.dp))
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
                            Spacer(modifier = Modifier.weight(1f))
                            Button(
                                onClick = {
                                    navController.navigate(route = Screen.Conseling3.route)
                                },
                                modifier = Modifier
                                    .width(130.dp)
                                    .height(40.dp)
                                    .padding(1.dp)
                                    .clip(shape = RoundedCornerShape(20.dp)),
                                colors = ButtonDefaults.buttonColors(Green4)
                            ) {
                                Text(
                                    text = "Choose",
                                    modifier = Modifier,
                                    fontSize = 14.sp,
                                    fontFamily = alegreyaFamily,
                                    fontWeight = FontWeight.SemiBold,
                                    textAlign = TextAlign.Center,
                                    color = Color.White,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConseling2Screen() {
        Conseling2Screen(
            navController = rememberNavController()
        )
}