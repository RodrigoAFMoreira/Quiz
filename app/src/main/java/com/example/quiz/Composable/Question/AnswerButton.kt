package com.example.quiz.Composable.Question

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnswerButton(
    answer: String,
    isSelected: Boolean,
    isCorrect: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) {
        if (isCorrect) Color.Green else Color.Red
    } else {
        Color.Black
    }

    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(top = 16.dp)
            .width(200.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        )
    ) {
        Text(
            text = answer,
            color = Color.White
        )
    }
}