package com.example.appmentalhealth.screen
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.ui.theme.Green4
import com.example.appmentalhealth.ui.theme.White
import com.example.appmentalhealth.ui.theme.alegreyaFamily
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ResetScreen(
    navController: NavController,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    val auth = FirebaseAuth.getInstance() // Initialize Firebase Authentication

    Dialog(
        onDismissRequest = {
            onDismiss()
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        )
    ) {
        Card(
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .width(250.dp)
                .height(170.dp)
                .border(1.dp, Color.White, shape = RoundedCornerShape(15.dp)),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Password Reset Link Sent",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                )
                // Content of your custom dialog
                Text(
                    text = "A password reset link has been sent \n" +
                            "to your email address. Please check \n" +
                            "your inbox.",
                    fontFamily = alegreyaFamily,
                    fontWeight = FontWeight.Thin,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                )
                Column(
                    modifier = Modifier
                        .width(210.dp)
                        .height(40.dp)
                        .clip(RoundedCornerShape(5.dp)),
                ) {
                    Button(
                        onClick = {
                            // Sign out the user
                            auth.performPasswordReset()
                            onConfirm()
                            navController.popBackStack()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(1.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        colors = ButtonDefaults.buttonColors(Green4)
                    ) {
                        Text(
                            text = "Ok",
                            fontFamily = alegreyaFamily,
                            fontWeight = FontWeight.Thin,
                            fontSize = 14.sp,
                            color = White,
                        )
                    }
                }
            }
        }
    }
}

private fun FirebaseAuth.performPasswordReset() {
    val auth = FirebaseAuth.getInstance()
    val userEmail = auth.currentUser?.email
    userEmail?.let { email ->
        auth.sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Password reset email sent successfully
                    var showDialog = true
                } else {
                    // Handle the error here
                    // You can log the error or show an error message
                    val exception = task.exception
                    Log.e("ProfileScreen", "Password reset failed: $exception")
                }
            }
    }
}

@Preview(showBackground = true)
@Composable
fun ResetScreenPreview() {
    // You can provide dummy values for NavController, onDismiss, and onConfirm
    val navController = rememberNavController()
    val onDismiss = {}
    val onConfirm = {}

    ResetScreen(navController, onDismiss, onConfirm)
}




