package com.neversitup.data.repository

import com.neversitup.data.model.asEntity
import com.neversitup.data.model.asPrice
import com.neversitup.database.dao.HistoryDao
import com.neversitup.model.Price
import com.neversitup.network.api.CoinApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PriceRepositoryImpl(
    private val historyDao: HistoryDao,
    private val api: CoinApi
) : PriceRepository {
    override fun getCurrentPrice(): Flow<Price> = flow {
        val response = api.fetchCurrentPrice()
        val entity = response.asEntity()
        historyDao.insertHistoryPriceEntity(entity)
        emit(entity.asPrice())
    }

    override fun getHistoryPrice(): Flow<List<Price>> = flow {
        emit(historyDao.getHistoryPriceEntities().map { it.asPrice() })
    }.flowOn(Dispatchers.IO)

    override fun getHistoryPriceById(id: Long) = flow {
        emit(historyDao.getHistoryPriceEntityById(id).asPrice())
    }.flowOn(Dispatchers.IO)

}