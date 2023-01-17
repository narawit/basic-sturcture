package com.neversitup.data.model

import com.neversitup.database.model.HistoryPriceEntity
import com.neversitup.model.Price
import com.neversitup.network.model.CurrentPriceResponse
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.*

fun CurrentPriceResponse.asEntity() =
    HistoryPriceEntity(
        id = Date().time,
        updated = time.updatedISO,
        disclaimer = disclaimer,
        chartName = chartName,
        bpi = Json.encodeToString(bpi.toList().map { it.second }),
    )

fun HistoryPriceEntity.asPrice() =
    Price(
        update = updated,
        data = Json.decodeFromString(bpi)
    )