package com.example.quiz.Composable.Question

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quiz.Model.Question

@Composable
fun QuestionScreen(
    question: Question,
    onNextClick: () -> Unit
) {
    val selectedAnswer = remember { mutableStateOf("") }
    val score = remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Quem é?",
                modifier = Modifier.padding(bottom = 16.dp),
                color = Color.White,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold
            )

            ImageQuestion(question.imageId)
            /*Text(
                text = question.name,
                modifier = Modifier.padding(bottom = 16.dp),
                color = Color.White
            )*/

            // Score text
            Text(
                text = "Score: ${score.value}",
                modifier = Modifier.padding(top = 16.dp),
                color = Color.White
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                question.answers.forEach { answer ->
                    AnswerButton(
                        answer = answer,
                        isSelected = answer == selectedAnswer.value,
                        isCorrect = answer == question.correctAnswer,
                        onClick = { selectedAnswer.value = answer }
                    )
                }
            }

            NextButton(
                onNextClick = onNextClick,
                correctAnswer = question.correctAnswer,
                selectedAnswer = selectedAnswer.value,
                countScore = score
            )
        }
    }
}
