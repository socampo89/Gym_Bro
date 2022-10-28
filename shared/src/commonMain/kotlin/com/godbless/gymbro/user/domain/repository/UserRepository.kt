package com.godbless.gymbro.user.domain.repository

import com.godbless.gymbro.helpers.Either
import com.godbless.gymbro.user.domain.entity.User
import com.godbless.gymbro.user.exception.UserException

interface UserRepository {
    suspend fun getCurrentUser() : Either<UserException, User>
    suspend fun saveUser(user:User) : Either<UserException, User>
    suspend fun logout() : Either<UserException, Boolean>
}