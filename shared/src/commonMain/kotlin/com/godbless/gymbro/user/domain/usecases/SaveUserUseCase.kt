package com.godbless.gymbro.user.domain.usecases

import com.godbless.gymbro.base.BaseUseCase
import com.godbless.gymbro.helpers.Either
import com.godbless.gymbro.user.domain.entity.User
import com.godbless.gymbro.user.domain.repository.UserRepository
import com.godbless.gymbro.user.exception.UserException

class SaveUserUseCase(private val userRepository: UserRepository) : BaseUseCase<UserException, User, User>() {

    override suspend fun invoke(params: User?): Either<UserException, User> {
        return params?.let {
            userRepository.saveUser(it)
        }?:run{
            Either.Left(UserException.NullException())
        }
    }
}