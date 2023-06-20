package com.example.quiz.Composable.QuizEnd

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.R
import com.example.quiz.nav.Screen

@Composable
fun EndQuizScreen(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.Black
            ) {
                Card(
                    backgroundColor = Color.Black,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "Parabéns, o Quiz acabou. Volte para o menu e veja seu ranking ou comece um novo jogo!",
                            style = MaterialTheme.typography.h6,
                            color = Color.White,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                    }
                }
            }
            Image(
                painter = painterResource(id = R.drawable.end_quiz),
                contentDescription = "Image Quiz End",
                modifier = Modifier.padding(top = 16.dp)
            )
            Button(
                onClick = { navController.navigate(Screen.Home.route) },
                modifier = Modifier.padding(bottom = 16.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black)
            ) {
                Text(text = "Voltar", color = Color.White)
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun EndQuizScreenPreview() {
    EndQuizScreen(
        navController = rememberNavController()
    )
}