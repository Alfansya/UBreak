package com.example.appmentalhealth.screen
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
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
import java.text.DateFormat
import java.util.Calendar
import com.example.appmentalhealth.screen.JournalScreen


@Composable
fun JournalConfirmationScreen( navController: NavController, date: String) {
    val calendar = Calendar.getInstance().time
    val dateFormat = DateFormat.getDateInstance().format(calendar)
    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }


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

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp),
            painter = painterResource(id = R.drawable.jurnal_confirmation),
            contentDescription = "image description",
            contentScale = ContentScale.None
        )

        Text(
            text = "Are you \n finished writing?",
            modifier = Modifier
                .width(320.dp),
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Thin,
            fontSize = 40.sp,
            color = Green3,
            textAlign = TextAlign.Center
        )

        Text(
            text = "once you hit submit, no more editing. " +
                    "Just keeping it real for your daily " +
                    "journaling vibes",
            modifier = Modifier
                .width(320.dp),
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Thin,
            fontSize = 16.sp,
            color = Green3,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier
                .padding(50.dp))

        Button(
            onClick = { navController.navigate(route = Screen.JournalHistory.route) },
            modifier = Modifier
                .width(320.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(15.dp)),
            colors = ButtonDefaults.buttonColors(Green4)

        ) {
            Text(
                text = "Submit my journal",
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Thin,
                fontSize = 16.sp,
                color = Color.White,
            )
        }

        Spacer(
            modifier = Modifier
                .padding(10.dp))

        Button(
            onClick = { navController.navigate(route = Screen.Journal.route)
            },
            modifier = Modifier
                .width(320.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(15.dp)),
            colors = ButtonDefaults.buttonColors(Green8)
        ) {
            Text(
                text = "Back to editing",
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Green3,
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewJournalConfirmationScreen() {
    AppMentalHealthTheme() {
        JournalConfirmationScreen(
            navController = rememberNavController(),
            "Android"
        )
    }
}
