package com.example.quiz.Composable.Question

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quiz.Composable.QuizEnd.EndQuizScreen
import com.example.quiz.Model.Question
import com.example.quiz.Model.QuestionList

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

            ImageForAnswer(question.imageId)
            // Text for the question
            Text(
                text = question.name,
                modifier = Modifier.padding(bottom = 16.dp),
                color = Color.White
            )

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
                score = score
            )
        }
    }
}

@Composable
fun ImageForAnswer(imageResId: Int) {
    val imageBitmap = ImageBitmap.imageResource(imageResId)
    val painter: Painter = BitmapPainter(imageBitmap)
    Image(
        painter,
        contentDescription = null,
        modifier = Modifier
            .width(300.dp)
            .height(300.dp)
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    )
}

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

@Composable
fun NextButton(
    onNextClick: () -> Unit,
    correctAnswer: String,
    selectedAnswer: String,
    score: MutableState<Int>
) {
    Button(
        onClick = {
            val isCorrect = correctAnswer == selectedAnswer
            if (isCorrect) {
                score.value++
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