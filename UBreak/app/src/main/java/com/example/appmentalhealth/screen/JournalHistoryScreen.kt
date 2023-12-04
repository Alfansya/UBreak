package com.example.appmentalhealth.screen
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
import java.text.DateFormat
import java.util.Calendar
import java.util.Date

@Composable
fun JournalHistoryScreen( navController: NavController) {
    val calendar = Calendar.getInstance().time
    val dateFormat = DateFormat.getDateInstance().format(calendar)

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState())
            .background(color = White)
            .padding(bottom = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    )
    {
        Image(
            painter = painterResource(id = R.drawable.iconmenu),
            contentDescription = null,
            Modifier
                .padding(top = 40.dp, bottom = 10.dp)
                .width(78.dp)
                .height(52.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = "Your Journaling Journey",
            fontFamily = alegreyaFamily,
            fontSize = 32.sp,
            fontWeight = FontWeight.Thin,
            color = Green2,
            modifier = Modifier
                .fillMaxWidth(),
            style = TextStyle(textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.padding(10.dp))

        // Column Loop
        repeat(3){
            Row {
                // Row Loop
                repeat(2){

                    Card(
                        modifier = Modifier
                            .width(180.dp)
                            .height(240.dp)
                            .padding(10.dp)
                            .shadow(elevation = 5.dp, shape = RoundedCornerShape(10.dp), clip = true),
                    ) {
                        Column {
                            Image(
                                painter = painterResource(id = R.drawable.album_cover),
                                contentDescription = "Album Cover",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                                    .padding(top = 10.dp, bottom = 5.dp)
                            )

                            Text(
                                text = "8th Week Journey",
                                fontFamily = alegreyaFamily,
                                fontWeight = FontWeight.Thin,
                                fontSize = 18.sp,
                                color = Green3,
                                modifier = Modifier
                                    .width(150.dp)
                                    .padding(top = 0.dp, bottom = 5.dp, start = 8.dp, end =8.dp)
                            )

                            Text(
                                text = "$dateFormat",
                                fontFamily = alegreyaFamily,
                                fontWeight = FontWeight.Thin,
                                fontSize = 12.sp,
                                color = Green3,
                                modifier = Modifier
                                    .width(150.dp)
                                    .padding(top = 0.dp, bottom = 5.dp, start = 8.dp, end =8.dp)
                            )

                        }
                    }
                }
            }
        }
    }
    // Bottom Navigation Bar
    BottomBarRow(
        items = listOf(
            BottomNavItem(route = Screen.Main.route, iconResId = R.drawable.home_new),
            BottomNavItem(route = Screen.Conseling.route, iconResId = R.drawable.konsel_new),
            BottomNavItem(route = Screen.JournalHistory.route, iconResId = R.drawable.jurnal_new),
            BottomNavItem(route = Screen.Profile.route, iconResId = R.drawable.profile_new)
        ),
        navController = navController,
        modifier = Modifier
            .fillMaxHeight()
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewJournalHistoryScreen() {
    AppMentalHealthTheme() {
        JournalHistoryScreen(
            navController = rememberNavController()
        )
    }
}
