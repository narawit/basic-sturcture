package com.neversitup.database.di

import androidx.room.Room
import com.neversitup.database.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "database"
        ).build()
    }

    single { get<AppDatabase>().historyDao() }
}