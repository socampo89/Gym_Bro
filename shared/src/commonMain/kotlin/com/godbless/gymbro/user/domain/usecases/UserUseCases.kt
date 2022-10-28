package com.godbless.gymbro.user.domain.usecases

data class UserUseCases(
    val getCurrentUserUseCase: GetCurrentUserUseCase,
    val logoutUserUseCase: LogoutUserUseCase,
    val saveUserUseCase: SaveUserUseCase
)