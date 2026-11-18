package edu.unicauca.sismovil.cinefy.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cinefy.shared.generated.resources.Res
import cinefy.shared.generated.resources.baseline_add_24
import cinefy.shared.generated.resources.baseline_star_24
import edu.unicauca.sismovil.cinefy.domain.model.Movie
import org.jetbrains.compose.resources.painterResource

@Composable
fun MovieListScreen(
    movies: List<Movie>,
    onNavigateToForm: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onNavigateToForm,
                text = { Text("Agregar") },
                icon = { Icon(painterResource(Res.drawable.baseline_add_24), contentDescription = "Agregar") }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).padding(16.dp)) {
            Text("Mis Películas Vistas", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            if (movies.isEmpty()) {
                Text("No has registrado ninguna película aún.", modifier = Modifier.padding(top = 16.dp))
            } else {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(movies) { movie ->
                        Card(modifier = Modifier.fillMaxWidth()) {
                            Row(
                                modifier = Modifier.fillMaxWidth().padding(16.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = movie.title,
                                    style = MaterialTheme.typography.titleLarge,
                                    modifier = Modifier.weight(1f)
                                )
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("${movie.rating}/5", style = MaterialTheme.typography.bodyLarge)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Icon(
                                        painter = painterResource(Res.drawable.baseline_star_24),
                                        contentDescription = "Star",
                                        tint = Color(0xFFFFC107)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
