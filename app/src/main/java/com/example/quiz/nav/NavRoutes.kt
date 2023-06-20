package com.example.quiz.nav

import ScoreScreen
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quiz.Composable.Home.HomeScreen
import com.example.quiz.Composable.Question.QuestionScreenFlow
import com.example.quiz.Model.User
import androidx.compose.runtime.remember
import com.example.quiz.Composable.QuizEnd.EndQuizScreen


@Composable
fun SetupNavRoutes(navController: NavHostController) {
    val players = remember { mutableStateListOf<User>() }

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                navController = navController,
                onNameEntered = { name ->
                    players.add(User(name, 0))
                    navController.navigate(Screen.Questions.route)
                }
            )
        }
        composable(route = Screen.Questions.route) {
            QuestionScreenFlow(navController = navController)
        }
        composable(route = Screen.Score.route) {
            ScoreScreen(players = players.take(10))
        }
        composable(
            route = Screen.End.route
        ){
            EndQuizScreen(navController = navController)
        }
    }

}