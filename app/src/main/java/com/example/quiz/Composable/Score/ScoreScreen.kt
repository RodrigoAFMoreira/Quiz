import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.quiz.Model.User
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.unit.dp

@Composable
fun ScoreScreen(
    players: List<User>
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            item {
                Text(
                    text = "Ranking",
                    modifier = Modifier.padding(bottom = 16.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.Bold
                )
            }

            itemsIndexed(players) { index, player ->
                Text(
                    text = "${index + 1}. ${player.nome} - Score: ${player.score}",
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = Color.White,
                    style = MaterialTheme.typography.h5
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScoreScreenPreview() {
    ScoreScreenPreview()
}