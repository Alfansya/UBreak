package com.example.appmentalhealth.screen

import androidx.compose.foundation.*
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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

@Composable
fun AssasmentScreen(
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
        // Gambar
        Image(
            painter = painterResource(id = R.drawable.assasmenticon),
            alignment = Alignment.Center,
            contentDescription = null,
            modifier = Modifier
                .padding(top = 100.dp)
                .width(118.dp)
                .height(118.dp)
                .background(color = White)
                .clip(RoundedCornerShape(25.dp)),
            contentScale = ContentScale.Crop
        )
            // Title
            Text(
                text = "Self-Assessment",
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Black,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 10.dp)
            )

            // Deskripsi
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla faucibus a nulla id maximus. Morbi aliquet, quam a imperdiet pretium, dolor ex commodo lectus, nec sagittis elit sem vel leo. Pellentesque in tortor condimentum, placerat lorem non, viverra neque. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nulla facilisi. Duis convallis placerat nibh, eu viverra nisi sollicitudin posuere. Fusce sed mollis lacus, at auctor turpis. Integer rhoncus pretium sem eget rutrum. Fusce dignissim turpis tellus, eget facilisis sapien elementum nec.",
                textAlign = TextAlign.Center,
                fontFamily = alegreyaFamily,
                fontWeight = FontWeight.Thin,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 20.dp, bottom = 200.dp)

            )

            Column(modifier = Modifier
                .width(250.dp)
                .height(40.dp)
                .clip(RoundedCornerShape(50.dp)),
                )
            {
                Button(
                    onClick = {
                    navController.navigate(route = Screen.Assasment1.route)
                    // Add your sign-in logic here
                    // Example: Check email and password, navigate to the home screen
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    colors = ButtonDefaults.buttonColors(Green4)
                ) {
                    Text(text = "Mulai Tes",
                        fontFamily = alegreyaFamily,
                        fontWeight = FontWeight.Thin,
                        fontSize = 16.sp,
                        color = White,)
                }
            }
        Spacer(
            modifier = Modifier.padding(20.dp)
        )
        }
    }

fun onSelectedChange(any: Any) {

}

@Preview(showBackground = true)
@Composable
fun PreviewAssasmentScreen() {
        AssasmentScreen( navController = rememberNavController()
        )
}