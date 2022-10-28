package com.godbless.gymbro.cache

import android.content.Context
import com.godbless.gymbro.database.GymBroDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context : Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(GymBroDatabase.Schema, context, "gymbro.db")
    }
}