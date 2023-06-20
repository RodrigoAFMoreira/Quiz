package com.example.quiz.Composable.Question

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.quiz.Composable.QuizEnd.EndQuizScreen
import com.example.quiz.Model.QuestionList

@Composable
fun QuestionScreenFlow(navController: NavController) {
    val questions = QuestionList.questions.shuffled().take(5)
    val currentQuestionIndex = remember { mutableStateOf(0) }

    if (currentQuestionIndex.value < questions.size) {
        QuestionScreen(
            question = questions[currentQuestionIndex.value],
            onNextClick = { currentQuestionIndex.value++ }
        )
    } else {
        EndQuizScreen(navController)
    }
}