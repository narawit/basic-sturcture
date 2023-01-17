package com.neversitup.common.extension

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*


fun <R> Flow<R>.onComplete(
    scope: CoroutineScope,
    action: suspend (value: R) -> Unit,
    failure: (suspend (value: Throwable) -> Unit)? = null,
    loading: (suspend () -> Unit)? = null,
    complete: (suspend () -> Unit)? = null
): Job {
    return this.onStart { loading?.invoke() }
        .onCompletion { complete?.invoke() }
        .catch { failure?.invoke(it) }
        .onEach { action.invoke(it) }
        .launchIn(scope)
}