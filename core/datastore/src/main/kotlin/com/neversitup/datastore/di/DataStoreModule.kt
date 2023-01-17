package com.neversitup.datastore.di

import android.content.Context
import com.neversitup.datastore.AppDataStore
import com.neversitup.datastore.PreferenceStorage
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataStoreModule = module {
    single {
        PreferenceStorage(
            androidApplication().getSharedPreferences(
                "sharedPreferences",
                Context.MODE_PRIVATE
            )
        )
    }
    single(named("SettingPref")) { AppDataStore(androidContext(), "datastore") }
}