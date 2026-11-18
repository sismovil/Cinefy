package edu.unicauca.sismovil.cinefy.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import edu.unicauca.sismovil.cinefy.data.database.CinefyDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(CinefyDatabase.Schema, "cinefy.db")
    }
}

