package com.example.appmentalhealth.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
fun Conseling2Screen(
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
            .padding(20.dp))
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

        Row(modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = White),
            horizontalArrangement = Arrangement.Center,) {
            Box(modifier = Modifier
                .clickable {
                    navController.navigate(route = Screen.Conseling3.route)
                })
            {
                Image(
                    modifier = Modifier
                        .width(200.dp)
                        .height(175.dp),
                    painter = painterResource(id = R.drawable.grup36637),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
            Box(modifier = Modifier
                .clickable {
                    navController.navigate(route = Screen.Conseling3.route)
                })
            {
                Image(
                    modifier = Modifier
                        .width(200.dp)
                        .height(175.dp),
                    painter = painterResource(id = R.drawable.grup36637),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

        }
        Spacer(modifier = Modifier
            .padding(20.dp))

        Row(modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = White),
            horizontalArrangement = Arrangement.Center,)
        {
            Box(modifier = Modifier
                .clickable {
                    navController.navigate(route = Screen.Conseling3.route)
                })
            {
                Image(
                    modifier = Modifier
                        .width(200.dp)
                        .height(175.dp),
                    painter = painterResource(id = R.drawable.grup36637),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
            Box(modifier = Modifier
                .clickable {
                    navController.navigate(route = Screen.Conseling3.route)
                })
            {
                Image(
                    modifier = Modifier
                        .width(200.dp)
                        .height(175.dp),
                    painter = painterResource(id = R.drawable.grup36637),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

        }
        Spacer(modifier = Modifier
            .padding(20.dp))
        Row(modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = White),
            horizontalArrangement = Arrangement.Center,)
        {
            Box(modifier = Modifier
                .clickable {
                    navController.navigate(route = Screen.Conseling3.route)
                })
            {
                Image(
                    modifier = Modifier
                        .width(200.dp)
                        .height(175.dp),
                    painter = painterResource(id = R.drawable.grup36637),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
            Box(modifier = Modifier
                .clickable {
                    navController.navigate(route = Screen.Conseling3.route)
                })
            {
                Image(
                    modifier = Modifier
                        .width(200.dp)
                        .height(175.dp),
                    painter = painterResource(id = R.drawable.grup36637),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

        }
        Spacer(modifier = Modifier
            .padding(20.dp))
        Row(modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = White),
            horizontalArrangement = Arrangement.Center,)
        {
            Box(modifier = Modifier
                .clickable {
                    navController.navigate(route = Screen.Conseling3.route)
                })
            {
                Image(
                    modifier = Modifier
                        .width(200.dp)
                        .height(175.dp),
                    painter = painterResource(id = R.drawable.grup36637),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

            Box(modifier = Modifier
                .clickable {
                    navController.navigate(route = Screen.Conseling3.route)
                })
            {
                Image(
                    modifier = Modifier
                        .width(200.dp)
                        .height(175.dp),
                    painter = painterResource(id = R.drawable.grup36637),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

        }

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
            ){
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
                    .clickable { navController.navigate(route = Screen.Conseling.route)}
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
                    .clickable { navController.navigate(route = Screen.Journal.route)})
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
fun PreviewConseling2Screen() {
        Conseling2Screen(
            navController = rememberNavController()
        )
}