package com.neversitup.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkResponse<T>(
    var statusCode: Int? = null,
    var message: String? = null,
    var data: T? = null,
)