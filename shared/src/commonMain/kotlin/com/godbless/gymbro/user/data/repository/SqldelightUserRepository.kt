package com.godbless.gymbro.user.data.repository


import com.godbless.gymbro.database.GymBroDatabase
import com.godbless.gymbro.helpers.DateTimeUtil
import com.godbless.gymbro.helpers.Either
import com.godbless.gymbro.helpers.toLong
import com.godbless.gymbro.user.domain.entity.User
import com.godbless.gymbro.user.domain.repository.UserRepository
import com.godbless.gymbro.user.exception.UserException

class SqldelightUserRepository(database: GymBroDatabase) : UserRepository {

    private val queries = database.gymbroQueries

    override suspend fun getCurrentUser(): Either<UserException, User> {
       queries.getCurrentUser().executeAsOneOrNull()?.let {
           return Either.Right(it.toUser())
       } ?: run{
           return Either.Left(UserException.NotFound())
       }
    }

    override suspend fun saveUser(user: User) : Either<UserException, User>{
        queries.saveUser(
            user.id,
            user.firstName,
            user.lastName,
            user.email,
            user.anonymous.toLong(),
            DateTimeUtil.toEpochMillis(user.created)
        )
        return getCurrentUser()
    }

    override suspend fun logout() : Either<UserException, Boolean> {
        queries.logout()
        return when(val currentUser = getCurrentUser()){
            is Either.Right -> {
                Either.Right(true)
            }
            is Either.Left -> {
                Either.Left(currentUser.getLeftOrNull() ?: UserException.NotFound())
            }
        }
    }
}