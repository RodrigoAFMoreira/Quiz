package com.example.quiz.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.quiz.Composable.Home.HomeScreen
import com.example.quiz.Composable.Question.QuestionScreen
import com.example.quiz.Composable.Score.ScoreScreen

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
            QuestionScreen(navController = navController)
        }
        composable(
            route = Screen.Score.route
        ){
            ScoreScreen(navController = navController)
        }
    }
}