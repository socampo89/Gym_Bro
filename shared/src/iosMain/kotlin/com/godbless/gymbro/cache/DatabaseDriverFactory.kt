package com.godbless.gymbro.cache

import com.godbless.gymbro.database.GymBroDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(GymBroDatabase.Schema, "gymbro.db")
    }
}