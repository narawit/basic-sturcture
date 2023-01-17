package com.neversitup.network.api

import com.neversitup.network.model.CurrentPriceResponse
import retrofit2.http.GET

interface CoinApi {

    @GET("bpi/currentprice.json")
    suspend fun fetchCurrentPrice(): CurrentPriceResponse
}