package com.neversitup.domain.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow

abstract class UseCase<Request, Result> {

    abstract fun checkRequest(request: Request): Request

    protected abstract suspend fun execute(request: Request): Flow<Result>

    operator fun invoke(request: Request): Flow<Result> =
        flow { emit(checkRequest(request)) }
            .flatMapConcat { execute(it) }
}