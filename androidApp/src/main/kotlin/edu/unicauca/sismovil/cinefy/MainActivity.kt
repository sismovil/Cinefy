package edu.unicauca.sismovil.cinefy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import edu.unicauca.sismovil.cinefy.data.local.DatabaseDriverFactory
import edu.unicauca.sismovil.cinefy.domain.repository.MovieRepositoryImpl
import edu.unicauca.sismovil.cinefy.presentation.ui.CinefyApp
import edu.unicauca.sismovil.cinefy.presentation.MovieViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val factory = DatabaseDriverFactory(applicationContext)
        val repository = MovieRepositoryImpl(factory)
        val viewModel = MovieViewModel(repository)

        setContent {
            CinefyApp(viewModel)
        }

    }
}