package edu.unicauca.sismovil.cinefy

import androidx.compose.ui.window.ComposeUIViewController
import edu.unicauca.sismovil.cinefy.data.local.DatabaseDriverFactory
import edu.unicauca.sismovil.cinefy.domain.repository.MovieRepositoryImpl
import edu.unicauca.sismovil.cinefy.presentation.ui.CinefyApp
import edu.unicauca.sismovil.cinefy.presentation.MovieViewModel

fun MainViewController() = ComposeUIViewController {
    val factory = DatabaseDriverFactory()
    val repository = MovieRepositoryImpl(factory)
    val viewModel = MovieViewModel(repository)

    CinefyApp(viewModel)
}
