package com.neversitup.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "history_price"
)
data class HistoryPriceEntity(
    @PrimaryKey
    val id: Long,
    val updated: String? = null,
    val disclaimer: String? = null,
    val chartName: String? = null,
    val bpi: String
)