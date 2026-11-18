
package edu.unicauca.sismovil.cinefy.domain.repository

import edu.unicauca.sismovil.cinefy.domain.model.Movie

interface MovieRepository {
    fun getAllMovies(): List<Movie>
    fun insertMovie(title: String, rating: Long)
    fun deleteMovie(id: Long)
}
