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

@Composable
fun JournalViewScreen( navController: NavController, date: String) {
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


        Box(
            modifier = Modifier
                .height(110.dp)
                .background(color = Color.White)
                .width(320.dp)
        ) {
            // Journal Title
            Text(
                text = "Let's see what you've been through",
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Thin,
                fontSize = 30.sp,
                color = Green3,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                )

        }
        Spacer(
            modifier = Modifier
                .padding(5.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(310.dp)
                .clip(RoundedCornerShape(25.dp)),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Column(
                modifier = Modifier
                    .height(420.dp)
                    .background(color = Green8)
                    .width(320.dp)
            ) {
                // Journal Content
                    Text(
                        text = "Lorem ipsum dolor sit amet, " +
                                "consectetur adipiscing elit. " +
                                "Praesent blandit urna eget congue dapibus. " +
                                "Curabitur luctus augue sed sem iaculis euismod. " +
                                "Nullam volutpat augue tincidunt nisl viverra, quis mollis velit consectetur. " +
                                "Cras nec massa quis quam suscipit pretium a vitae lectus.",
                        fontFamily = alegreyaFamily,
                        fontWeight = FontWeight.Thin,
                        fontSize = 18.sp,
                        color = Green3,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier
                            .padding(16.dp)
                            .padding(bottom = 0.dp)
                            .fillMaxWidth()
                    )

                Text(
                    text = "$dateFormat",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Thin,
                    fontSize = 18.sp,
                    color = Green3,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .padding(16.dp)
                        .padding(top = 0.dp)
                        .fillMaxWidth()
                    )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween

                ){
                    Text(
                        text = "Journal Title",
                        fontFamily = alegreyaFamily,
                        fontWeight = FontWeight.Thin,
                        fontSize = 18.sp,
                        color = Green3,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier
                            .padding(start = 10.dp, end = 16.dp)
                            .wrapContentWidth()
                    )
                    Text(
                        text = "1 of 7",
                        fontFamily = alegreyaFamily,
                        fontWeight = FontWeight.Thin,
                        fontSize = 18.sp,
                        color = Green3,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier
                            .padding(start = 10.dp, end = 16.dp)
                            .wrapContentWidth()
                    )
                }


                Image(
                    painter = painterResource(id = R.drawable.jurnal_preview),
                    contentDescription = null,
                    Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                )

                }
            }

        Spacer(
            modifier = Modifier
                .padding(10.dp))

        Button(
            onClick = {
            },
            modifier = Modifier
                .width(320.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(15.dp)),
            colors = ButtonDefaults.buttonColors(Green4)

        ) {
            Text(
                text = "Next",
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
            onClick = {
            },
            modifier = Modifier
                .width(320.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(15.dp)),
            colors = ButtonDefaults.buttonColors(Green8)
        ) {
            Text(
                text = "Back",
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
fun PreviewJournalViewScreen() {
    AppMentalHealthTheme() {
        JournalViewScreen(
            navController = rememberNavController(),
            "Android"
        )
    }
}
