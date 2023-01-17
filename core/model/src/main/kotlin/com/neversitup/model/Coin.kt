package com.neversitup.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Price(
    val update: String?,
    val data: List<Coin> = listOf()
) {
    @Serializable
    data class Coin(
        val code: String? = null,
        val symbol: String? = null,
        val rate: String? = null,
        val description: String? = null,
        @SerialName("rate_float")
        val rateFloat: Float? = null
    )
}