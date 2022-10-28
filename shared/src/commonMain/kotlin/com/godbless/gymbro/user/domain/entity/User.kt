package com.godbless.gymbro.user.domain.entity

import kotlinx.datetime.LocalDateTime

data class User(
    val id : Long,
    val firstName : String,
    val lastName : String,
    val email : String,
    val anonymous : Boolean,
    val created : LocalDateTime
)