package com.example.appmentalhealth.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.Screen
import com.example.appmentalhealth.ui.theme.*

@Composable
fun ProfileScreen(
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
                .padding(10.dp)
        )

        Text(
            text = "Profile",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        // Gambar
        Image(
            painter = painterResource(id = R.drawable.profile1),
            contentDescription = null,
            Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Account",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        Card(
            modifier = Modifier
                .border(1.dp, color = Color.Black)
                .width(350.dp)
                .fillMaxHeight(),
        )
        {
            Box(
                Modifier
                    .padding(20.dp)
                    .width(200.dp)
                    .clickable { navController.navigate(route = Screen.Profile1.route) }
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                Modifier
                    .padding(20.dp)
                    .padding(top = 70.dp)
                    .width(200.dp)
                    .clickable { navController.navigate(route = Screen.Profile2.route) }
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.reset),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                Modifier
                    .padding(20.dp)
                    .padding(top = 150.dp)
                    .width(200.dp)
                    .clickable { navController.navigate(route = Screen.Profile.route) }
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }

        }

        Text(
            text = "More",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )

        Card(
            modifier = Modifier
                .border(1.dp, color = Color.Black)
                .width(350.dp)
                .fillMaxHeight(),
        )
        {
            Box(
                Modifier
                    .padding(20.dp)
                    .width(200.dp)
                    .clickable { navController.navigate(route = Screen.Profile.route) }
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.help),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                Modifier
                    .padding(20.dp)
                    .padding(top = 70.dp)
                    .width(200.dp)
                    .clickable { navController.navigate(route = Screen.Profile3.route) }
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.about),
                    contentDescription = null,
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )

        Row(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = White),
            horizontalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = Modifier
                    .clickable {
                        navController.navigate(route = Screen.Main.route)
                    }
            ) {
                Image(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .width(57.dp)
                        .height(80.dp),
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

            Box(
                modifier = Modifier
                    .clickable { navController.navigate(route = Screen.Conseling.route) }
            )
            {
                Image(
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .width(57.dp)
                        .height(80.dp),
                    painter = painterResource(id = R.drawable.konsel),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }


            Box(
                modifier = Modifier
                    .clickable { navController.navigate(route = Screen.Journal.route) })
            {
                Image(
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .width(57.dp)
                        .height(80.dp),
                    painter = painterResource(id = R.drawable.jurnal),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }


            Box(
                modifier = Modifier
                    .clickable { navController.navigate(route = Screen.Profile.route) })
            {
                Image(
                    modifier = Modifier
                        .padding(start = 40.dp)
                        .width(57.dp)
                        .height(80.dp),
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
        ProfileScreen(
            navController = rememberNavController()
        )
}