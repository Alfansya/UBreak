package com.example.appmentalhealth.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.Screen
import com.example.appmentalhealth.data.UserViewModel
import com.example.appmentalhealth.ui.theme.AppMentalHealthTheme
import com.example.appmentalhealth.ui.theme.Green1
import com.example.appmentalhealth.ui.theme.Green2
import com.example.appmentalhealth.ui.theme.Green7
import com.example.appmentalhealth.ui.theme.White
import com.example.appmentalhealth.ui.theme.alegreyaFamily

@Composable
fun MainScreen(
    navController: NavController
) {
    val viewModel: UserViewModel = viewModel()
    val userName by viewModel.userName.observeAsState("Loading...")

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 20.dp)
            .background(color = Green7),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.padding(20.dp))
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
            text = "Hello, $userName!",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            color = Green1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, top = 10.dp)
                .padding(vertical = 8.dp),
            style = TextStyle(textAlign = TextAlign.Start)
        )
        Text(
            text = "How are you feeling today!",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Thin,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp),
            style = TextStyle(textAlign = TextAlign.Start)
        )

        Divider(
            color = Green2,
            thickness = 2.dp,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 5.dp)
                .width(350.dp)
                .background(Color.Black, shape = RoundedCornerShape(0.dp, 0.dp, 100.dp, 100.dp))
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
                painter = painterResource(id = R.drawable.happy_new),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Image(
                modifier = Modifier
                    .padding(start = 80.dp)
                    .width(57.dp)
                    .height(80.dp),
                painter = painterResource(id = R.drawable.relax_new),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Image(
                modifier = Modifier
                    .padding(start = 160.dp)
                    .width(57.dp)
                    .height(80.dp),
                painter = painterResource(id = R.drawable.sad_new),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
            Image(
                modifier = Modifier
                    .padding(start = 240.dp)
                    .width(57.dp)
                    .height(80.dp),
                painter = painterResource(id = R.drawable.stress_new),
                contentDescription = "image description",
                contentScale = ContentScale.None
            )
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 40.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(color = White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 30.dp, top = 20.dp),
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Thin,
                fontSize = 24.sp,
                text = "Let's take a break.",
                color = Green1,
                style = TextStyle(textAlign = TextAlign.Start)
            )

            Box(modifier = Modifier.clickable { navController.navigate(route = Screen.Assasment.route) }) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(20.dp),
                    painter = painterResource(id = R.drawable.self_new),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

            Box(modifier = Modifier.clickable { navController.navigate(route = Screen.Journal.route) }) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(20.dp),
                    painter = painterResource(id = R.drawable.daily_new),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }

            Box(modifier = Modifier.clickable { navController.navigate(route = Screen.Conseling.route) }) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(top = 20.dp, bottom = 40.dp),
                    contentDescription = "image description",
                    painter = painterResource(id = R.drawable.counseling_new),
                    contentScale = ContentScale.None
                )
            }
        }
    }

    // Bottom Navigation Bar
    BottomBarRow(
        items = listOf(
            BottomNavItem(route = Screen.Main.route, iconResId = R.drawable.home_new),
            BottomNavItem(route = Screen.Conseling.route, iconResId = R.drawable.konsel_new),
            BottomNavItem(route = Screen.Journal.route, iconResId = R.drawable.jurnal_new),
            BottomNavItem(route = Screen.Profile.route, iconResId = R.drawable.profile_new)
        ),
        navController = navController
    )

}
@Composable
fun BottomBarRow(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val currentRoute = getCurrentRoute(navController)

    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        items.forEach { item ->
            val isSelected = item.route == currentRoute
            val alphaValue = if (isSelected) 1.0f else 0.5f

            Box(
                modifier = Modifier
                    .height(80.dp)
                    .background(color = Color.White)
                    .clickable {
                        navController.navigate(route = item.route)
                    }
            ) {
                Image(
                    modifier = Modifier
                        .width(105.dp)
                        .height(80.dp)
                        .alpha(alphaValue),
                    painter = painterResource(id = item.iconResId),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
        }
    }
}

@Composable
fun getCurrentRoute(navController: NavController): String {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route ?: ""
}


data class BottomNavItem(
    val route: String,
    val iconResId: Int
)

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    AppMentalHealthTheme() {
        MainScreen(
            navController = rememberNavController()
        )
    }
}
