package com.neversitup.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.neversitup.database.dao.HistoryDao
import com.neversitup.database.model.HistoryPriceEntity

@Database(
    entities = [HistoryPriceEntity::class],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}
