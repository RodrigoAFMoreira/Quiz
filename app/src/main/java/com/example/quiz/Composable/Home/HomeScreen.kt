package com.example.quiz.Composable.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.quiz.R
import com.example.quiz.nav.Screen

@Composable
fun HomeScreen(
    navController: NavController,
    onNameEntered: (String) -> Unit
) {
    val playerName = remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Quiz",
                color = Color.White,
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.quiz),
                contentDescription = "Image Quiz",
                modifier = Modifier.padding(top = 16.dp)
            )

            TextField(
                value = playerName.value,
                onValueChange = { playerName.value = it },
                modifier = Modifier.padding(top = 16.dp)
            )

            if (playerName.value.isBlank()) {
                Text(
                    text = "Por favor, insira seu nome",
                    color = Color.Cyan,
                    fontSize = MaterialTheme.typography.caption.fontSize,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

            Button(
                onClick = {
                    if (playerName.value.isNotBlank()) {
                        onNameEntered(playerName.value)
                        navController.navigate(Screen.Questions.route)
                    }
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black
                )
            ) {
                Text(
                    text = "Começar",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = { navController.navigate(Screen.Score.route) },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black
                )
            ) {
                Text(
                    text = "Pontuação",
                    color = Color.White,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(
        navController = rememberNavController(),
        onNameEntered = {}
    )
}