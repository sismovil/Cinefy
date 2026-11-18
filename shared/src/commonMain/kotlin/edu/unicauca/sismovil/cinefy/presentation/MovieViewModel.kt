package edu.unicauca.sismovil.cinefy.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import edu.unicauca.sismovil.cinefy.domain.model.Movie
import edu.unicauca.sismovil.cinefy.domain.repository.MovieRepository

class MovieViewModel(private val repository: MovieRepository) : ViewModel() {
    var movies by mutableStateOf(emptyList<Movie>())
        private set

    init {
        loadMovies()
    }

    fun loadMovies() {
        movies = repository.getAllMovies()
    }

    fun addMovie(title: String, rating: Long) {
        repository.insertMovie(title, rating)
        loadMovies()
    }

    fun deleteMovie(id: Long){
        repository.deleteMovie(id)
        loadMovies()
    }
}
