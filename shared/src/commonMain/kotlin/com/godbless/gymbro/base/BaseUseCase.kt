package com.godbless.gymbro.base

import com.godbless.gymbro.helpers.Either


abstract class BaseUseCase<L, R, in Params> {
    abstract suspend fun invoke(params : Params?) : Either<L, R>
}
class None
