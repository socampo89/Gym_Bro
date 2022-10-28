package com.godbless.gymbro.android.di.user

import com.godbless.gymbro.database.GymBroDatabase
import com.godbless.gymbro.user.data.repository.SqldelightUserRepository
import com.godbless.gymbro.user.domain.repository.UserRepository
import com.godbless.gymbro.user.domain.usecases.GetCurrentUserUseCase
import com.godbless.gymbro.user.domain.usecases.LogoutUserUseCase
import com.godbless.gymbro.user.domain.usecases.SaveUserUseCase
import com.godbless.gymbro.user.domain.usecases.UserUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UserComponent {

    @Provides
    @Singleton
    fun provideSqldelightUserRepository(database: GymBroDatabase) : UserRepository{
        return SqldelightUserRepository(database)
    }

    @Provides
    @Singleton
    fun provideUserUseCases(repository: UserRepository) : UserUseCases{
        return UserUseCases(
            GetCurrentUserUseCase(repository),
            LogoutUserUseCase(repository),
            SaveUserUseCase(repository)
        )
    }
}