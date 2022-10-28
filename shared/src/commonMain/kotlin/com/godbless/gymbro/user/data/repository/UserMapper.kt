package com.godbless.gymbro.user.data.repository

import com.godbless.gymbro.helpers.toBoolean
import com.godbless.gymbro.user.domain.entity.User
import database.UserEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

fun UserEntity.toUser() : User{
    return User(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email,
        anonymous = anonymous.toBoolean(),
        created = Instant.fromEpochMilliseconds(created).toLocalDateTime(TimeZone.currentSystemDefault())
    )
}