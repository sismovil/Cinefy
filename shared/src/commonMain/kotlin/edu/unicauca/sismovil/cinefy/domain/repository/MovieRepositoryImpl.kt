package edu.unicauca.sismovil.cinefy.domain.repository

import edu.unicauca.sismovil.cinefy.data.database.CinefyDatabase
import edu.unicauca.sismovil.cinefy.data.local.DatabaseDriverFactory
import edu.unicauca.sismovil.cinefy.domain.model.Movie

class MovieRepositoryImpl(databaseDriverFactory: DatabaseDriverFactory): MovieRepository {

    private val database = CinefyDatabase(databaseDriverFactory.createDriver())
    private val dbQueries = database.cinefyDabaseQueries

    override fun getAllMovies(): List<Movie> {
        return dbQueries.selectAllMovies().executeAsList().map { dbMovie ->
            Movie(id = dbMovie.id, title = dbMovie.title, rating = dbMovie.rating)
        }
    }

    override fun insertMovie(title: String, rating: Long) {
        dbQueries.insertMovie(title, rating)

    }

    override fun deleteMovie(id: Long) {
        dbQueries.deleteMovie(id)
    }
}