package com.example.appmentalhealth.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
fun Conseling3Screen(
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
            text = "Select a Date And Time",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.desktopdatepicker),
            contentDescription = null,
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Tuesday, November 17",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Spacer(
            modifier = Modifier
                .padding(5.dp)
        )

        Row(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = White),
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(modifier = Modifier
                .clickable {

                })
            {
                Image(
                    modifier = Modifier
                        .width(73.dp)
                        .height(25.dp),
                    painter = painterResource(id = R.drawable.jam15),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

            Spacer(
                modifier = Modifier
                    .padding(20.dp)
            )

            Box(modifier = Modifier
                .clickable {

                })
            {
                Image(
                    modifier = Modifier
                        .width(73.dp)
                        .height(25.dp),
                    painter = painterResource(id = R.drawable.jam315),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

            Spacer(
                modifier = Modifier
                    .padding(20.dp)
            )

            Box(modifier = Modifier
                .clickable {

                })
            {
                Image(
                    modifier = Modifier
                        .width(73.dp)
                        .height(25.dp),
                    painter = painterResource(id = R.drawable.jam515),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

        }

        Text(
            text = "Choose a Method",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Spacer(
            modifier = Modifier
                .padding(5.dp)
        )

        Row(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = White),
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(modifier = Modifier
                .clickable {

                })
            {
                Image(
                    modifier = Modifier
                        .width(73.dp)
                        .height(25.dp),
                    painter = painterResource(id = R.drawable.online),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

            Spacer(
                modifier = Modifier
                    .padding(20.dp)
            )

            Box(modifier = Modifier
                .clickable {

                })
            {
                Image(
                    modifier = Modifier
                        .width(73.dp)
                        .height(25.dp),
                    painter = painterResource(id = R.drawable.offline),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
        }

        Spacer(
            modifier = Modifier
                .padding(20.dp)
        )

        Column(
            Modifier
                .width(250.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(50.dp)),
        )
        {
            Button(
                onClick = {
                    navController.navigate(route = Screen.Conseling4.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(Green4),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        color = White,
                        text = "Confirm Scheduled",
                        fontFamily = alegreyaFamily,
                        fontWeight = FontWeight.Thin,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )

                }
            }
        }
        Spacer(
            modifier = Modifier
                .padding(20.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewConseling3Screen() {
        Conseling3Screen(
            navController = rememberNavController()
        )
}