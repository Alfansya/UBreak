package com.example.appmentalhealth.screen
import android.util.Log
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
import com.example.appmentalhealth.ui.theme.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.text.DateFormat
import java.util.Calendar

@Composable
fun JournalScreen(navController: NavController, date: String) {
    val calendar = Calendar.getInstance().time
    val dateFormat = DateFormat.getDateInstance().format(calendar)
    var title by remember { mutableStateOf("") }
    var text by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }
    val userId = FirebaseAuth.getInstance().currentUser?.uid ?: return

    val db = FirebaseFirestore.getInstance() // Firebase Firestore Instance

    // Fungsi untuk menyimpan data ke Firestore
    fun saveJournalToFirestore(userId: String, title: String, date: String, text: String) {
        val journalEntry = hashMapOf(
            "userId" to userId, // Add the userId to the journal entry
            "title" to title,
            "date" to date,
            "text" to text
        )

        db.collection("journals")
            .add(journalEntry)
            .addOnSuccessListener { documentReference ->
                Log.d("JournalScreen", "DocumentSnapshot written with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("JournalScreen", "Error adding document", e)
            }
    }
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


        Box(
            modifier = Modifier
                .height(60.dp)
                .background(color = Color.White)
                .width(320.dp)
        ) {

            // Journal Title
            if (title.isEmpty() && !isFocused) {
                Text(
                    text = "Write Your Feelings Here...",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Thin,
                    fontSize = 22.sp,
                    color = Green3,
                    modifier = Modifier.padding(10.dp)
                )
            }

            TextField(
                value = title,
                onValueChange = {
                    title = it
                },
                textStyle = LocalTextStyle.current.copy(
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Thin,
                    fontSize = 22.sp,
                    color = Green3
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedLabelColor = White,
                    unfocusedLabelColor = White,
                    focusedBorderColor = White,
                    unfocusedBorderColor = White,
                    cursorColor = Green3,
                    leadingIconColor = Green3,
                    trailingIconColor = White,
                ),
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Text(
            text = "$dateFormat",
            modifier = Modifier
                .width(300.dp)
                .padding(top = 2.dp, bottom = 20.dp),
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Thin,
            fontSize = 16.sp,
            color = Green3
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(310.dp)
                .clip(RoundedCornerShape(25.dp)),
            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            Box(
                modifier = Modifier
                    .height(450.dp)
                    .background(color = Green8)
                    .width(320.dp)
            ) {

                // Journal Content
                if (text.isEmpty() && !isFocused) {
                    Text(
                        text = "Write your thoughts here...",
                        fontFamily = alegreyaFamily,
                        fontWeight = FontWeight.Thin,
                        fontSize = 18.sp,
                        color = Green3,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                TextField(
                    value = text,
                    onValueChange = {
                        text = it
                    },
                    textStyle = LocalTextStyle.current.copy(
                        fontFamily = alegreyaFamily,
                        fontWeight = FontWeight.Thin,
                        fontSize = 18.sp,
                        color = Green2
                    ),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedLabelColor = White,
                        unfocusedLabelColor = White,
                        focusedBorderColor = White,
                        unfocusedBorderColor = White,
                        cursorColor = Green3,
                        leadingIconColor = Green3,
                        trailingIconColor = White,
                    ),
                    modifier = Modifier
                        .fillMaxSize()
                )
            }

        }


        Spacer(
            modifier = Modifier
                .padding(10.dp)
        )



        Spacer(
            modifier = Modifier
                .padding(20.dp))

        JournalBottomBar(
            items = listOf(
                BottomNavItem(route = Screen.Main.route, iconResId = R.drawable.jurnal_edit),
                BottomNavItem(route = Screen.Journal.route, iconResId = R.drawable.jurnal_kamera),
                BottomNavItem(route = Screen.Journal.route, iconResId = R.drawable.jurnal_mic),
                BottomNavItem(route = Screen.JournalConfirmation.route, iconResId = R.drawable.jurnal_fixed)
            ),
            navController = navController,
            onSaveClick = {
                saveJournalToFirestore(userId, title, dateFormat, text) // Pass the save function
            }
        )

    }
}

@Composable
fun JournalBottomBar(
    items: List<BottomNavItem>,
    navController: NavController,
    onSaveClick: () -> Unit, // New parameter for save action
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .width(320.dp)
            .padding(bottom = 30.dp)
            .clip(RoundedCornerShape(25.dp)),
        verticalAlignment = Alignment.Bottom
    ) {
        items.forEachIndexed { index, item ->
            Box(
                modifier = Modifier
                    .height(80.dp)
                    .background(Green4)
                    .clickable {
                        if (index == 3) { // Assuming the first button is save
                            onSaveClick() // Call the save action
                            navController.navigate(route = item.route)
                        } else {
                            navController.navigate(route = item.route)
                        }
                    }
            ) {
                Image(
                    modifier = Modifier
                        .width(80.dp)
                        .height(80.dp),
                    painter = painterResource(id = item.iconResId),
                    contentDescription = "image description",
                    contentScale = ContentScale.None
                )
            }
        }
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
