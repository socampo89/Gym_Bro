package com.godbless.gymbro.helpers

fun Boolean.toLong() : Long{
    if(this){
        return 1L
    }
    return 0L
}