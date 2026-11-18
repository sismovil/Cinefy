package edu.unicauca.sismovil.cinefy.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MovieFormScreen(
    onSaveMovie: (String, Long) -> Unit,
    onNavigateToList: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf(5L) }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Registrar Película Vista", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Título de la película") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Puntuación: $rating / 5")
        Slider(
            value = rating.toFloat(),
            onValueChange = { rating = it.toLong() },
            valueRange = 1f..5f,
            steps = 3
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                if (title.isNotBlank()) {
                    onSaveMovie(title, rating)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Película")
        }
        TextButton(onClick = onNavigateToList) {
            Text("Ver lista de películas")
        }
    }
}
