package edu.unicauca.sismovil.cinefy.data.local

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import edu.unicauca.sismovil.cinefy.data.database.CinefyDatabase

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(CinefyDatabase.Schema, context, "cinefy.db")
    }
}
