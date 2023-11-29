package com.example.appmentalhealth

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appmentalhealth.data.UserViewModel
import com.example.appmentalhealth.screen.*
import com.example.appmentalhealth.data.UsersData

@RequiresApi(Build.VERSION_CODES.P)
@Composable
fun SetupNavGraph(
    navController : NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ){
        composable(
            route = Screen.Welcome.route
        ){
            WelcomeScreen(navController)
        }
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController)
        }
        composable(
            route = Screen.Main.route
        ){
            MainScreen(navController)
        }
        composable(
            route = Screen.Assasment.route
        ){
            AssasmentScreen(navController)
        }
        composable(
            route = Screen.Assasment1.route
        ){
            Assasment1Screen(navController)
        }
        composable(
            route = Screen.Assasment2.route
        ){
            Assasment2Screen(navController)
        }
        composable(
            route = Screen.Assasment3.route
        ){
            Assasment3Screen(navController)
        }
        composable(
            route = Screen.AssasmentResult.route
        ){
            AssasmentResultScreen(navController)
        }
        composable(
            route = Screen.Journal.route
        ){
            JournalScreen(navController, date = String())
        }
        composable(
            route = Screen.JournalHistory.route
        ){
            JournalHistoryScreen(navController)
        }
        composable(
            route = Screen.Conseling.route
        ){
            ConselingScreen(navController)
        }
        composable(
            route = Screen.Conseling1.route
        ){
            Conseling1Screen(navController)
        }
        composable(
            route = Screen.Conseling2.route
        ){
            Conseling2Screen(navController)
        }
        composable(
            route = Screen.Conseling3.route
        ){
            Conseling3Screen(navController)
        }
        composable(
            route = Screen.Conseling4.route
        ){
            Conseling4Screen(navController)
        }
        composable(
            route = Screen.Conseling5.route
        ){
            Conseling5Screen(navController)
        }
        composable(
            route = Screen.Profile.route
        ) {

            ProfileScreen(
                navController = rememberNavController(),
                userData = UsersData()
            )
        }
        composable(
            route = Screen.ProfileEdit.route
        ){
            val viewModel = viewModel<UserViewModel>()
            ProfileEdit(
                navController = rememberNavController(),
                viewModel = viewModel
            )
        }
        composable(
            route = Screen.Profile2.route
        ){
            Profile2Screen(navController)
        }
        composable(
            route = Screen.Profile3.route
        ){
            Profile3Screen(navController)
        }
        composable(
            route = Screen.Sign.route
        ){
            SignScreen(navController)
        }
        composable(
            route = Screen.Forgot.route
        ){
            ForgotScreen(navController)
        }


    }
}

