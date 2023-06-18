package com.example.quiz.nav


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quiz.Composable.Home.HomeScreen
import com.example.quiz.Composable.Question.QuestionScreenFlow
import com.example.quiz.Composable.ScoreScreen


@Composable
fun SetupNavRoutes(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
        ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Questions.route
        ){
            QuestionScreenFlow()
        }
        composable(
            route = Screen.Score.route
        ){
            ScoreScreen(navController = navController)
        }
    }
}