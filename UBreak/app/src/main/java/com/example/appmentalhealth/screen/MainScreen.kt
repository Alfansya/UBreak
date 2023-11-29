package com.example.appmentalhealth.screen
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.example.appmentalhealth.ui.theme.AppMentalHealthTheme
import com.example.appmentalhealth.ui.theme.Green7
import com.example.appmentalhealth.ui.theme.White
import com.example.appmentalhealth.ui.theme.alegreyaFamily

@Composable
fun MainScreen( navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(color = Green7),
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

        // Welcome User
        Text(
            text = "Hello, Nama!",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = White,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = "How are you felling today!" ,
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Thin,
            fontSize = 20.sp,
        )

        Box(
            Modifier
                .padding(vertical = 8.dp)
                .width(315.dp)
                .height(82.dp)
        ) {
            Image(
                modifier = Modifier
                    .width(57.dp)
                    .height(80.dp),
                painter = painterResource(id = R.drawable.happy),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Image(
                modifier = Modifier
                    .padding(start = 80.dp)
                    .width(57.dp)
                    .height(80.dp),
                painter = painterResource(id = R.drawable.relax),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Image(
                modifier = Modifier
                    .padding(start = 160.dp)
                    .width(57.dp)
                    .height(80.dp),
                painter = painterResource(id = R.drawable.sad),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Image(
                modifier = Modifier
                    .padding(start = 240.dp)
                    .width(57.dp)
                    .height(80.dp),
                painter = painterResource(id = R.drawable.stress),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(20.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(color = White),
            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            Text(
                modifier = Modifier
                    .padding(start = 10.dp, bottom = 20.dp),
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Black,
                fontSize = 30.sp,
                text = "Lets take a break.")

            Box(modifier = Modifier
            .clickable {
                navController.navigate(route = Screen.Assasment.route)
            }) {

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(20.dp),
                painter = painterResource(id = R.drawable.self),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            }

            Box(modifier = Modifier
                .clickable {
                    navController.navigate(route = Screen.Journal.route)
                })
            {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(20.dp),
                    painter = painterResource(id = R.drawable.daily),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

            Box(modifier = Modifier
                .clickable {
                    navController.navigate(route = Screen.Conseling.route)
                })
            {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(20.dp),
                    painter = painterResource(id = R.drawable.konseling),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
        }
        Spacer(
            modifier = Modifier.padding(28.dp)
        )
        Row(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
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
fun PreviewMainScreen() {
    AppMentalHealthTheme() {
        MainScreen(
            navController = rememberNavController()
        )
    }
}