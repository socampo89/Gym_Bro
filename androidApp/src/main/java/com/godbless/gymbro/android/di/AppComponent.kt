package com.godbless.gymbro.android.di

import android.app.Application
import com.godbless.gymbro.cache.DatabaseDriverFactory
import com.godbless.gymbro.database.GymBroDatabase
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppComponent {

    @Provides
    @Singleton
    fun provideSqlDriverFactory(app : Application) : SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideGymDataBase(driver: SqlDriver) : GymBroDatabase {
        return GymBroDatabase(driver)
    }
}