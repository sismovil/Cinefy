package edu.unicauca.sismovil.cinefy.presentation.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import edu.unicauca.sismovil.cinefy.presentation.MovieViewModel


enum class CinefyScreen { FORM, LIST }

@Composable
fun CinefyApp(viewModel: MovieViewModel) {
    var currentScreen by remember { mutableStateOf(CinefyScreen.FORM) }
    Surface {
        when (currentScreen) {
            CinefyScreen.FORM -> MovieFormScreen(
                onSaveMovie = { title, rating ->
                    viewModel.addMovie(title, rating)
                    currentScreen = CinefyScreen.LIST
                },
                onNavigateToList = { currentScreen = CinefyScreen.LIST }
            )
            CinefyScreen.LIST -> MovieListScreen(
                movies = viewModel.movies,
                onNavigateToForm = { currentScreen = CinefyScreen.FORM }
            )
        }
    }
}

