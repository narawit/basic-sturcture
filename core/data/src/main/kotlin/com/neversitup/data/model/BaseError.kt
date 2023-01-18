package com.neversitup.data.model

data class BaseError(
    val code: Int? = null,
    val message:String? = null,
    val json: String? = null
)