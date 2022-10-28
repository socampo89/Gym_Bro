package com.godbless.gymbro.android.home

import com.godbless.gymbro.user.domain.entity.User
import com.godbless.gymbro.user.exception.UserException

data class HomeScreenState(
    val user : User? = null,
    val failure : UserException? = null
)