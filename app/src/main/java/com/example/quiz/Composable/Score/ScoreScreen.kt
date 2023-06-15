package com.example.quiz.Composable.Score

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.Model.User
import com.example.quiz.nav.Screen

@Composable
fun ScoreScreen(navController: NavController) {
    val scores = generateScores()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(modifier = Modifier.fillMaxWidth().align(Alignment.TopCenter)) {
            items(scores) { score ->
                Text(
                    text = "${score.nome}: ${score.score}",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .clickable {
                            navController.navigate(Screen.Home.route) {
                                popUpTo(Screen.Home.route) {
                                    inclusive = true
                                }
                            }
                        }
                        .padding(vertical = 4.dp)
                )
            }
        }

        Button(
            onClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) {
                        inclusive = true
                    }
                }
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .width(200.dp)
                .height(50.dp)
                .padding(vertical = 4.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black
            )
        ) {
            Text(
                text = "Voltar",
                color = Color.White,
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScoreScreenPreview() {
    ScoreScreen(
        navController = rememberNavController()
    )
}

fun generateScores(): List<User> {
    val scores = mutableListOf<User>()
    scores.add(User("name 1", 100))
    scores.add(User("name 2", 200))
    scores.add(User("name 3", 300))
    return scores
}
