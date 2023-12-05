package com.example.appmentalhealth.screen
import android.util.Log
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
import com.google.firebase.firestore.FirebaseFirestore
import java.text.DateFormat
import java.util.Calendar
data class Journal(
    val title: String = "",
    val text: String = "",
    val date: String = ""
)

fun fetchJournals(userId: String, onResult: (List<Journal>) -> Unit) {
    FirebaseFirestore.getInstance()
        .collection("journals")
        .get()
        .addOnSuccessListener { documents ->
            Log.d("JournalViewScreen", "Documents fetched successfully")
            val journals = documents.mapNotNull { it.toObject(Journal::class.java) }
            onResult(journals)
        }
        .addOnFailureListener { exception ->
            Log.w("JournalViewScreen", "Error getting documents: ", exception)
        }
}

@Composable
fun JournalViewScreen(navController: NavController, userId: String) {
    val journals = remember { mutableStateListOf<Journal>() }
    var currentJournalIndex by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = Unit) {
        fetchJournals(userId) { fetchedJournals ->
            journals.addAll(fetchedJournals)
        }
    }

    val currentJournal = journals.getOrNull(currentJournalIndex)

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
                        text = currentJournal?.text ?: "Loading...",
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
                    text = currentJournal?.date ?: "",
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
                        text = currentJournal?.title ?: "",
                        fontFamily = alegreyaFamily,
                        fontWeight = FontWeight.Thin,
                        fontSize = 18.sp,
                        color = Green3,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier
                            .padding(start = 10.dp, end = 16.dp)
                            .wrapContentWidth()
                    )
//                    Text(
//                        text = "1 of 7",
//                        fontFamily = alegreyaFamily,
//                        fontWeight = FontWeight.Thin,
//                        fontSize = 18.sp,
//                        color = Green3,
//                        textAlign = TextAlign.Justify,
//                        modifier = Modifier
//                            .padding(start = 10.dp, end = 16.dp)
//                            .wrapContentWidth()
//                    )
                }


//                Image(
//                    painter = painterResource(id = R.drawable.jurnal_preview),
//                    contentDescription = null,
//                    Modifier
//                        .padding(10.dp)
//                        .fillMaxWidth()
//                )

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
