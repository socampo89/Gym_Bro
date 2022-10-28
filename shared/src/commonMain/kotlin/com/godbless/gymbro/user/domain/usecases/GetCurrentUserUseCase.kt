package com.godbless.gymbro.user.domain.usecases

import com.godbless.gymbro.base.BaseUseCase
import com.godbless.gymbro.base.None
import com.godbless.gymbro.helpers.Either
import com.godbless.gymbro.user.domain.entity.User
import com.godbless.gymbro.user.domain.repository.UserRepository
import com.godbless.gymbro.user.exception.UserException

class GetCurrentUserUseCase(private val userRepository: UserRepository) : BaseUseCase<UserException, User, None>() {
    override suspend fun invoke(params : None?): Either<UserException, User> {
       return userRepository.getCurrentUser()
    }
}