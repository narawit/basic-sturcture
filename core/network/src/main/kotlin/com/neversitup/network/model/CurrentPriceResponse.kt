package com.neversitup.network.model

import kotlinx.serialization.Serializable

@Serializable
data class CurrentPriceResponse(
    val time: Time,
    val disclaimer: String,
    val chartName: String,
    val bpi: Map<String, Coin>
) {
    @Serializable
    data class Time(
        val updated: String,
        val updatedISO: String,
        val updateduk: String
    )

    @Serializable
    data class Coin(
        val code: String,
        val symbol: String,
        val rate: String,
        val description: String,
        val rate_float: Float
    )
}
