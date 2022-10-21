package com.godbless.gymbro

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform