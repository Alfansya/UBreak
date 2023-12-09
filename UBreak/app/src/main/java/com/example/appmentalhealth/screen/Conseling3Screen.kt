package com.example.appmentalhealth.screen

import android.widget.CalendarView
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.R
import com.example.appmentalhealth.Screen
import com.example.appmentalhealth.ui.theme.*
import java.util.Calendar
import java.util.Locale

@Composable
fun Conseling3Screen(
    navController: NavController
) {
    var date by remember{ mutableStateOf("")
    }
    var selectedTimeIndex by remember { mutableStateOf(-1) }
    var selectedMethodIndex by remember { mutableStateOf(-1) }

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

        Text(
            text = "Select a Date And Time",
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        )
        Column(

            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            AndroidView(factory = { context ->
                CalendarView(context).apply {
                    // Mendapatkan tanggal hari ini
                    val today = Calendar.getInstance()

                    // Menetapkan batas minimal untuk memilih tanggal
                    minDate = today.timeInMillis

                    // Menangani perubahan tanggal yang dipilih
                    setOnDateChangeListener { _, year, month, dayOfMonth ->
                        val selectedDate = Calendar.getInstance()
                        selectedDate.set(year, month, dayOfMonth)

                        // Memeriksa apakah tanggal yang dipilih sesuai dengan batas minimal
                        if (!selectedDate.before(today)) {
                            // Jika sesuai, update teks dengan tanggal yang dipilih
                            val dayOfWeek = selectedDate.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
                            date = "$dayOfWeek - $dayOfMonth/${month + 1}/$year"
                        } else {
                            // Jika tidak sesuai, set tanggal yang dipilih ke tanggal minimal (hari ini)
                            date = "${today.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())} - " +
                                    "${today.get(Calendar.DAY_OF_MONTH)}/${today.get(Calendar.MONTH) + 1}/${today.get(Calendar.YEAR)}"
                            setDate(today.timeInMillis)
                        }
                    }
                }
            }, update = {})

            Text(text = date,
                modifier = Modifier,
                fontSize = 18.sp,
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center)
        }
        Spacer(modifier = Modifier.padding(5.dp))

        Row(
            modifier = Modifier
                .padding(10.dp)
                .width(350.dp)
        ) {
            TimeButton("12.00", selectedTimeIndex, 0) {
                selectedTimeIndex = 0
                // TODO: Add your logic here
            }

            TimeButton("13.00", selectedTimeIndex, 1) {
                selectedTimeIndex = 1
                // TODO: Add your logic here
            }

            TimeButton("14.00", selectedTimeIndex, 2) {
                selectedTimeIndex = 2
                // TODO: Add your logic here
            }
        }


        Spacer(modifier = Modifier.padding(5.dp))
        Text(
            text = "Choose a Method",
            modifier = Modifier,
            fontSize = 18.sp,
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.Black,
        )

        Row(
            modifier = Modifier
                .padding(10.dp)
                .width(350.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            MethodButton("Offline", selectedMethodIndex, 0) {
                selectedMethodIndex = 0
                // TODO: Add your logic here
            }

            MethodButton("Online", selectedMethodIndex, 1) {
                selectedMethodIndex = 1
                // TODO: Add your logic here
            }
        }


        Spacer(
            modifier = Modifier
                .padding(20.dp)
        )

        Column(
            Modifier
                .width(250.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(50.dp)),
        )
        {
            Button(
                onClick = {
                    navController.navigate(route = Screen.ConselingDialog.route)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .shadow(elevation = 10.dp, shape = RoundedCornerShape(10.dp), clip = true),
                colors = ButtonDefaults.buttonColors(Green4),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        color = White,
                        text = "Confirm Scheduled",
                        fontFamily = alegreyaFamily,
                        fontWeight = FontWeight.Thin,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )

                }
            }
        }
        Spacer(
            modifier = Modifier
                .padding(20.dp)
        )
    }
}


@Composable
fun TimeButton(
    text: String,
    selectedIndex: Int,
    buttonIndex: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(start = if (buttonIndex > 0) 10.dp else 0.dp)
            .width(100.dp)
            .height(30.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(50.dp), clip = true)
            .clip(shape = RoundedCornerShape(50.dp)),
        colors = if (selectedIndex == buttonIndex) {
            ButtonDefaults.buttonColors(backgroundColor = Green4)
        } else {
            ButtonDefaults.buttonColors(backgroundColor = White)
        }
    ) {
        Text(
            text = text,
            modifier = Modifier,
            fontSize = 12.sp,
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = if (selectedIndex == buttonIndex) White else Green4,
        )
    }
}

@Composable
fun MethodButton(
    text: String,
    selectedIndex: Int,
    buttonIndex: Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(start = 10.dp, top = 5.dp)
            .width(100.dp)
            .height(30.dp)
            .shadow(elevation = 4.dp, shape = RoundedCornerShape(50.dp), clip = true)
            .clip(shape = RoundedCornerShape(50.dp)),
        colors = if (selectedIndex == buttonIndex) {
            ButtonDefaults.buttonColors(backgroundColor = Green4)
        } else {
            ButtonDefaults.buttonColors(backgroundColor = White)
        }
    ) {
        Text(
            text = text,
            modifier = Modifier,
            fontSize = 12.sp,
            fontFamily = alegreyaFamily,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = if (selectedIndex == buttonIndex) White else Green4,
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewConseling3Screen() {
        Conseling3Screen(
            navController = rememberNavController()
        )
}
