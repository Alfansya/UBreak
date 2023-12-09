package com.example.appmentalhealth

sealed class Screen(val route: String){
    object Welcome: Screen(route = "welcome_screen")
    object Login: Screen(route = "login_screen")
    object Main: Screen(route = "main_screen")
    object Assasment: Screen(route = "assasment_screen")
    object Assasment1: Screen(route = "assasment1_screen")
    object Assasment2: Screen(route = "assasment2_screen")
    object Assasment3: Screen(route = "assasment3_screen")
    object Journal: Screen(route = "journal_screen")
    object JournalConfirmation: Screen(route = "journal_confirmation")
    object JournalView: Screen(route = "journal_view")
    object JournalHistory: Screen(route = "journalhistory_screen")
    object AssasmentResult: Screen(route = "cresult_screen")
    object Conseling: Screen(route = "conseling_screen")
    object Conseling1: Screen(route = "conseling1_screen")
    object Conseling2: Screen(route = "conseling2_screen")
    object Conseling3: Screen(route = "conseling3_screen")
    object Conseling4: Screen(route = "conseling4_screen")
    object Conseling5: Screen(route = "conseling5_screen")
    object Profile: Screen(route = "profile_screen")
    object ProfileEdit: Screen(route = "profileedit_screen")
    object Profile3: Screen(route = "profile3_screen")
    object Sign: Screen(route = "sign_screen")
    object Forgot: Screen(route="forgot_screen")
    object Logout: Screen(route = "logout_screen")
    object Reset: Screen(route = "reset_screen")
    object AssasmentResult2: Screen(route = "result2_screen")
    object AssasmentResult3: Screen(route = "result3.screen")
    object ConselingDialog: Screen(route = "conseling_dialog")
}
