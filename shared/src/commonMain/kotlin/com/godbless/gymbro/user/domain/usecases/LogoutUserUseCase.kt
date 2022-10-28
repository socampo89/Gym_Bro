package com.godbless.gymbro.user.domain.usecases

import com.godbless.gymbro.base.BaseUseCase
import com.godbless.gymbro.base.None
import com.godbless.gymbro.helpers.Either
import com.godbless.gymbro.user.domain.repository.UserRepository
import com.godbless.gymbro.user.exception.UserException

class LogoutUserUseCase(private val userRepository: UserRepository) : BaseUseCase<UserException, Boolean, None>() {
    override suspend fun invoke(params: None?): Either<UserException, Boolean> {
        return userRepository.logout()
    }
}