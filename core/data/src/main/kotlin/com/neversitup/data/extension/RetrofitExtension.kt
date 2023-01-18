package com.neversitup.data.extension

import com.neversitup.data.model.BaseError
import retrofit2.HttpException

fun HttpException?.error() =
    this?.let { BaseError(it.code(), it.message(), it.response()?.errorBody()?.string()) }