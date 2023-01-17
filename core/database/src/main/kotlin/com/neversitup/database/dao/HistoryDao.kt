package com.neversitup.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.neversitup.database.model.HistoryPriceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoryPriceEntity(historyPriceEntity: HistoryPriceEntity): Long

    @Query(value = "SELECT * FROM history_price")
    fun getHistoryPriceEntities(): List<HistoryPriceEntity>

    @Query(value = "SELECT * FROM history_price WHERE id = :id")
    fun getHistoryPriceEntityById(id : Long): HistoryPriceEntity
}