package com.neversitup.data.repository

import com.neversitup.model.Price
import kotlinx.coroutines.flow.Flow

interface PriceRepository {
    fun getCurrentPrice(): Flow<Price>
    fun getHistoryPrice(): Flow<List<Price>>
    fun getHistoryPriceById(id: Long): Flow<Price>
}