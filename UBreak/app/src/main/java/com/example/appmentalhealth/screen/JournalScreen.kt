package com.example.appmentalhealth.screen
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
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
import java.text.DateFormat
import java.util.Calendar

@Composable
fun JournalScreen( navController: NavController, date: String) {
    val calendar = Calendar.getInstance().time
    val dateFormat = DateFormat.getDateInstance().format(calendar)
    var text by remember { mutableStateOf("") }
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

        // Welcome User
        Text(
            text = "Write your feelings here...",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 29.sp,
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(30.dp)
        )
        Text(text = "Date: $dateFormat")
        
        Spacer(
            modifier = Modifier
                .padding(20.dp))
        Column(
            modifier = Modifier
                .width(307.dp)
                .height(62.dp)
                .clip(RoundedCornerShape(25.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "I hope something was you make smile today.",
                modifier = Modifier
                    .width(307.dp)
                    .height(62.dp)
                    .background(color = Green6),
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
                fontFamily = alegreyaFamily,
                fontSize = 20.sp,
            )
        }
        Spacer(
            modifier = Modifier
                .padding(20.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(310.dp)
                .clip(RoundedCornerShape(25.dp)),
            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            TextField(
                label = { Text("Start typing...") },
                value = text,
                onValueChange = { text = it },
                modifier = Modifier
                    .height(200.dp)
                    .background(color = Green6)
                    .fillMaxWidth(),
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp ,end = 30.dp)
                .height(40.dp),
            horizontalAlignment = Alignment.End,
        ) {
            Button(
                onClick = {
                    navController.navigate(route = Screen.Main.route)
                    // Add your sign-in logic here
                    // Example: Check email and password, navigate to the home screen
                },
                modifier = Modifier
                    .width(100.dp)
                    .padding(end = 10.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(Green4)
            ) {
                Text(text = "Post",
                    textAlign = TextAlign.Center,
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Thin,
                    fontSize = 20.sp,
                    color = White,
                )
            }
        }

        Spacer(
            modifier = Modifier
                .padding(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(RoundedCornerShape(25.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                onClick = {
                    navController.navigate(route = Screen.JournalHistory.route)
                    // Add your sign-in logic here
                    // Example: Check email and password, navigate to the home screen
                },
                modifier = Modifier
                    .width(150.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .fillMaxHeight(),
                colors = ButtonDefaults.buttonColors(Green4)
            ) {
                Text(text = "History",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Thin,
                    fontSize = 20.sp,
                    color = White,)

            }
        }

        Spacer(
            modifier = Modifier
                .padding(20.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewJournalScreen() {
    AppMentalHealthTheme() {
        JournalScreen(
            navController = rememberNavController(),
            "Android"
        )
    }
}
