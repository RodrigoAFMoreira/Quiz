package com.example.quiz.Composable.Question

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NextButton(
    onNextClick: () -> Unit,
    correctAnswer: String,
    selectedAnswer: String,
    countScore: MutableState<Int>
) {
    Button(
        onClick = {
            val isCorrect = correctAnswer == selectedAnswer
            if (isCorrect) {
                countScore.value++
            }
            onNextClick.invoke()
        },
        modifier = Modifier.padding(top = 16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black
        )
    ) {
        Text(
            text = "Próximo",
            color = Color.White,
        )
    }
}