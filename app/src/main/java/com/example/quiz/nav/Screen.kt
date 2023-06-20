package com.example.quiz.nav

sealed class Screen(val route: String){
    object Home: Screen(route = "home_screen")
    object Questions: Screen(route = "questions_screen")
    object Score: Screen(route = "score_screen")
    object End: Screen(route = "quizEnd_screen")
}
